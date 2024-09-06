package hr.tis.academy.service;

import hr.tis.academy.dto.ProductsOrderDto;
import hr.tis.academy.model.ProductsOrder;

import java.util.List;
import java.util.UUID;

public interface ProductOrderService {
    List<ProductsOrder> getAllProductOrders();
    ProductsOrder getProductOrderByUUID(UUID uuid);
    List<ProductsOrder> getActiveOrders();
    ProductsOrderDto saveProductOrder(ProductsOrder productsOrder);
    Boolean deactivateProductsOrder(UUID productOrderId);
}
