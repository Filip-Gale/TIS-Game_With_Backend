package hr.tis.academy.repository;

import hr.tis.academy.db.Database;
import hr.tis.academy.model.Product;
import hr.tis.academy.model.ProductsMetadata;

import java.math.BigDecimal;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ProductRepositoryDB implements ProductRepository {

  @Override
  public Long insertProducts(ProductsMetadata ProductsMetadata) {
    String recordSQL = "INSERT INTO PRODUCTS_METADATA (CREATION_TIME, TITLE) VALUES (?, ?)";
    String productSQL = "INSERT INTO PRODUCTS (NAME, PRICE, CURRENCY, SCORE, PRODUCTS_METADATA_ID) VALUES (?, ?, ?, ?, ?)";
    long recordId;
    try (Connection connection = Database.getInstance().getConnection()) {
      connection.setAutoCommit(false);
      try (PreparedStatement recordStmt = connection.prepareStatement(recordSQL,
              Statement.RETURN_GENERATED_KEYS)) {
        recordStmt.setDate(1, Date.valueOf(ProductsMetadata.getCreationDateTime().toLocalDate()));
        recordStmt.setString(2, ProductsMetadata.getTitle());
        recordStmt.executeUpdate();
        try (ResultSet generatedKeys = recordStmt.getGeneratedKeys()) {
          if (generatedKeys.next()) {
            recordId = generatedKeys.getLong(1);
            try (PreparedStatement productStmt = connection.prepareStatement(productSQL)) {
              for (Product product : ProductsMetadata.getProducts()) {
                productStmt.setString(1, product.getName());
                productStmt.setBigDecimal(2, product.getPrice());
                productStmt.setString(3, product.getCurrency());
                productStmt.setInt(4, product.getScore());
                productStmt.setLong(5, recordId);
                productStmt.addBatch();
              }
              productStmt.executeBatch();
            }
          } else {
            throw new RuntimeException("Creating PRODUCTS_METADATA failed, no ID obtained.");
          }
        }
      }
      connection.commit();
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
    System.out.println(recordId + "recordid");
    return recordId;

  }

  @Override
  public BigDecimal fetchSumOfPrices(LocalDate createdDate) {
    return null;
  }

  @Override
  public BigDecimal fetchSumOfPrices(Long id) {
    return null;
  }

  @Override
  public ProductsMetadata fetchProductsMetadata(LocalDate createdDate) {
    return null;
  }

  @Override
  public ProductsMetadata fetchProductsMetadata(Long id) {
    String querySQL = "SELECT * FROM PRODUCTS_METADATA WHERE ID = ?";
    String productsSQL = "SELECT * FROM PRODUCTS WHERE PRODUCTS_METADATA_ID = ?";
    List<Product> products = new ArrayList<>();
    try (Connection connection = Database.getInstance().getConnection();
         PreparedStatement preparedStatement =
                 connection.prepareStatement(querySQL)) {
      preparedStatement.setLong(1, id);
      ResultSet resultSet = preparedStatement.executeQuery();

      try(PreparedStatement preparedStatementProducts =
                  connection.prepareStatement(productsSQL)) {
        preparedStatementProducts.setLong(1, id);
        ResultSet resultSetProducts = preparedStatementProducts.executeQuery();
        while (resultSetProducts.next()) {
          products.add(new Product(resultSetProducts.getString("NAME"), resultSetProducts.getBigDecimal("PRICE"), resultSetProducts.getString("CURRENCY"), resultSetProducts.getInt("SCORE")));
        }
      }

      if (resultSet.next()) {
        System.out.println(resultSet.getLong("ID"));
        System.out.println(resultSet.getTimestamp("CREATION_TIME"));
        System.out.println(resultSet.getString("TITLE"));

        return new ProductsMetadata(id, resultSet.getTimestamp("CREATION_TIME").toLocalDateTime(),  resultSet.getString("TITLE"), products);
      }
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
    return null;
  }

  @Override
  public Integer fetchProductsMetadataCount() {
    return null;
  }

  @Override
  public BigDecimal calculateSumOfPrices(List<Product> products) {
    return null;
  }
}
