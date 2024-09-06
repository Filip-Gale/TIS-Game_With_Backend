package hr.tis.academy.model;

import jakarta.persistence.*;

import java.awt.print.Book;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "PRODUCTS_ORDER", schema = "PRODUCT_MANAGER")
public class ProductsOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;

    @Column
    private Boolean isActive;
    @Column
    private LocalDateTime orderPlacedTime;
    @Column
    private LocalDate deliveryDate;
    @ManyToOne
    @JoinColumn(name = "store_id")
    private Store store;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @OneToOne
    private ProductsMetadata productMetadata;

    public BigDecimal calculateOrderCost(){
        return productMetadata.getProducts().stream()
                .map(Product::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public ProductsOrder() {}

    public ProductsOrder(Boolean isActive, LocalDateTime orderPlacedTime, LocalDate deliveryDate, Store store, Employee employee, ProductsMetadata productMetadata) {
        this.isActive = isActive;
        this.orderPlacedTime = orderPlacedTime;
        this.deliveryDate = deliveryDate;
        this.store = store;
        this.employee = employee;
        this.productMetadata = productMetadata;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public ProductsMetadata getProductMetadata() {
        return productMetadata;
    }

    public void setProductMetadata(ProductsMetadata productMetadata) {
        this.productMetadata = productMetadata;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public LocalDateTime getOrderPlacedTime() {
        return orderPlacedTime;
    }

    public void setOrderPlacedTime(LocalDateTime orderPlacedTime) {
        this.orderPlacedTime = orderPlacedTime;
    }
}
