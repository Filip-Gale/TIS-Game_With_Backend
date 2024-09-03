package hr.tis.academy.controller;

import hr.tis.academy.dto.ProductsMetadataDto;
import hr.tis.academy.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {this.productService = productService;}

    @GetMapping
    public ProductsMetadataDto fetchProductsFromWeb(){return productService.fetchProductsFromWeb();}

    @GetMapping
    public ProductsMetadataDto saveProductsFromWeb(){return productService.saveProductsFromWeb();}

    @GetMapping
    public ProductsMetadataDto getProductsForDate(LocalDate date){return productService.getProductsForDate(date);}
}
