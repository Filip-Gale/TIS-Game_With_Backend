package hr.tis.academy.model;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ProductsMetadata {
  private Long id;
  private LocalDateTime creationDateTime;
  private String title;
  private List<Product> products;

  public ProductsMetadata() {
    this.creationDateTime = LocalDateTime.now();
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public LocalDateTime getCreationDateTime() {
    return creationDateTime;
  }

  public void setCreationDateTime(LocalDateTime creationDateTime) {
    this.creationDateTime = creationDateTime;
  }

  public ProductsMetadata(Long id, LocalDateTime creationDateTime, String title, List<Product> products) {
    this.id = id;
    this.creationDateTime = creationDateTime;
    this.title = title;
    this.products = products;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public List<Product> getProducts() {
    return products;
  }

  public void setProducts(List<Product> products) {
    this.products = products;
  }

  public static void main(String[] args) {
    ProductsMetadata productsMetadata = new ProductsMetadata();
    List<Product> products = new ArrayList<>();
    products.add(new Product("Majica", new BigDecimal(12.99), "EUR", 2));
    products.add(new Product("Haljina", new BigDecimal(30.99), "EUR", 5));
    productsMetadata.setProducts(products);
    System.out.println(productsMetadata);
  }

  @Override
  public String toString() {
    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

    return "ProductsMetadata{" + "id=" + id + ", creationDateTime=" + creationDateTime.format(myFormatObj) + ", title='" + title + '\'' + ", products=" + products + '}';
  }
}
