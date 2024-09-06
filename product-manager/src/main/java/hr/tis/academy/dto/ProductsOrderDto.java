package hr.tis.academy.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public class ProductsOrderDto {
    private String employeeName;
    private  Long employeeId;
    private UUID OrderId;
    private BigDecimal orderPrice;
    private LocalDate deliveryDate;

    public ProductsOrderDto(String employeeName, Long employeeId, UUID orderId, BigDecimal orderPrice, LocalDate deliveryDate) {
        this.employeeName = employeeName;
        this.employeeId = employeeId;
        OrderId = orderId;
        this.orderPrice = orderPrice;
        this.deliveryDate = deliveryDate;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public UUID getOrderId() {
        return OrderId;
    }

    public void setOrderId(UUID orderId) {
        OrderId = orderId;
    }

    public BigDecimal getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(BigDecimal orderPrice) {
        this.orderPrice = orderPrice;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }
}
