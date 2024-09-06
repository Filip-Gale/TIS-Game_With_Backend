package hr.tis.academy.controller;

import hr.tis.academy.dto.ProductsOrderDto;
import hr.tis.academy.model.ProductsOrder;
import hr.tis.academy.service.ProductOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/order/")
public class OrderController {

    private final ProductOrderService productOrderService;

    @Autowired
    public OrderController(ProductOrderService productOrderService) {
        this.productOrderService = productOrderService;
    }

    @GetMapping
    public List<ProductsOrder> getAllOrders() {
        return productOrderService.getAllProductOrders();
    }

    @GetMapping("{id}")
    public ProductsOrder getOrderById(@PathVariable UUID id) {
        return productOrderService.getProductOrderByUUID(id);
    }

    @GetMapping("active")
    public List<ProductsOrder> getActiveOrders() {
        return productOrderService.getActiveOrders();
    }

    @PostMapping
    public ProductsOrderDto createOrder(@RequestBody ProductsOrder productsOrder) {
        return productOrderService.saveProductOrder(productsOrder);
    }

    @PutMapping("orderUpdate/{id}")
    public Boolean updateOrder(@PathVariable UUID id) {
        return productOrderService.deactivateProductsOrder(id);
    }
}
