package hr.tis.academy.model;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.DecimalFormat;

@Entity
@Table(name = "PRODUCT", schema = "PRODUCT_MANAGER")
public class Product implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column
  private String name;
  @Column
  private BigDecimal price;
  @Column
  private String currency;
  @Column
  private int score;
  @ManyToOne
  @JoinColumn(name = "PRODUCTS_METADATA_ID", nullable = false)
  private ProductsMetadata productsMetadata;

  public Product() {

  }

  public int getScore() {
    return score;
  }

  public Product(String name, int score, ProductsMetadata productsMetadata) {
    this.name = name;
    this.score = score;
    this.productsMetadata = productsMetadata;
  }

  public Product(String name, BigDecimal price, String currency, int score) {
    this.name = name;
    this.price = price;
    this.currency = currency;
    this.score = score;
  }

  public void setScore(int score) {
    this.score = score;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public BigDecimal getPrice() {
    return price;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }

  public String getCurrency() {
    return currency;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
  }

 /* @Override
  public String toString() {
    DecimalFormat df = new DecimalFormat("#,###.00");

    return "Product{" +
            "name='" + name + '\'' +
            ", price=" + df.format(price) + " " + currency +
            ", score=" + score +
            '}';
  }*/
}
