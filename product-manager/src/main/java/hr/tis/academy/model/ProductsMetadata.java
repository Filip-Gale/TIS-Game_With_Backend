package hr.tis.academy.model;

import hr.tis.academy.file.ProductReader;
import hr.tis.academy.file.ProductWriter;
import hr.tis.academy.repository.ProductRepositoryFile;
import hr.tis.academy.repository.ProductRepositoryInMemory;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
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

  public ProductsMetadata() {}

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
    ArrayList<Product> products = new ArrayList<>();
    ArrayList<Product> products2 = new ArrayList<>();

    products.add(new Product("lol", BigDecimal.valueOf(1),"r",3));
    products.add(new Product("lol2",BigDecimal.valueOf(12),"r2",4));

    products2.add(new Product("lol",new BigDecimal("1"),"r",3));
    products2.add(new Product("Čokolino 1kg",new BigDecimal("7.19"),"EUR/kg",5));

    ProductsMetadata p = new ProductsMetadata(null, LocalDateTime.now(),"yay",products);
    ProductsMetadata p2 = new ProductsMetadata(null, LocalDateTime.now(),"yay2",products2);
    ProductsMetadata p3 = new ProductsMetadata(null, LocalDateTime.now(),"yay3",products2);

    ProductRepositoryInMemory prim = new ProductRepositoryInMemory();

    prim.insertProducts(p);
    prim.insertProducts(p2);

    //System.out.println("calculateSumOfPrices " + prim.calculateSumOfPrices(p.getProducts()));

    //ProductWriter.writeProducts(p2);

    //System.out.println(ProductReader.read("1_2024-08-30T01$59$50.077972600_yay3.txt").getTitle());

    ProductRepositoryFile prf = new ProductRepositoryFile();
    prf.insertProducts(p3);
    //prf.fetchProductsMetadata(LocalDate.now());
    System.out.println("prf.fetchSumOfPrices(1L); " + prf.fetchSumOfPrices(1L));
    //System.out.println("fetchProductsMetadata " + prf.fetchProductsMetadata(1L));
    //System.out.println("fetchProductsMetadataCount " + prf.fetchProductsMetadataCount());
  }
}
