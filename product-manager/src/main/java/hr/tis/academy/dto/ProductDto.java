package hr.tis.academy.dto;

import java.math.BigDecimal;

public class ProductDto {

    private String name;
    private BigDecimal price;
    private String currency;
    private int score;

    public ProductDto(String name, BigDecimal price, String currency, int score) {
        this.name = name;
        this.price = price;
        this.currency = currency;
        this.score = score;
    }

    public int getScore() {
        return score;
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

}
