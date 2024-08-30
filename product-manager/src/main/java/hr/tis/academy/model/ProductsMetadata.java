package hr.tis.academy.model;

import hr.tis.academy.repository.ProductRepositoryInMemory;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ProductsMetadata {
  private Long id;
  private LocalDateTime creationDateTime;
  private String title;
  private List<Product> products;

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

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(title).append(" ").append(creationDateTime).append("\n");

    return sb.toString();
  }

  public static void main(String[] args) {
    ArrayList<Product> products = new ArrayList<>();
    ArrayList<Product> products2 = new ArrayList<>();

    products.add(new Product("lol", BigDecimal.valueOf(1),"r",3));
    products.add(new Product("lol2",BigDecimal.valueOf(12),"r2",4));

    products2.add(new Product("lol",BigDecimal.valueOf(1),"r",3));
    products2.add(new Product("lol2",BigDecimal.valueOf(15),"r2",4));

    ProductsMetadata p = new ProductsMetadata(0L, LocalDateTime.now(),"yay",products);
    ProductsMetadata p2 = new ProductsMetadata(1L, LocalDateTime.now(),"yay2",products2);




    ProductRepositoryInMemory prim = new ProductRepositoryInMemory();

    prim.getProductsMetadataList().add(p);
    prim.getProductsMetadataList().add(p2);

    System.out.println( prim.calculateSumOfPrices(p.getProducts()));
  }
}
