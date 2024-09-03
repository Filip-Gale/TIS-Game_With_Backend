package hr.tis.academy.service.impl;

import hr.tis.academy.model.ProductsMetadata;
import hr.tis.academy.repository.ProductRepository;
import hr.tis.academy.scraper.WebScraper;
import hr.tis.academy.service.ProductService;
import org.hibernate.annotations.CollectionTypeRegistration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;
    private final WebScraper webScraper;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, WebScraper webScraper) {
        this.productRepository = productRepository;
        this.webScraper = webScraper;
    }
    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductsMetadata fetchProductsFromWeb() {
        return webScraper.fetchProducts();
    }

    @Override
    public ProductsMetadata saveProductsFromWeb() {
        ProductsMetadata productsMetadata = webScraper.fetchProducts();
        productRepository.insertProducts(productsMetadata);
        return null;
    }

    @Override
    public ProductsMetadata getProductsForDate(LocalDate date) {
        return productRepository.fetchProductsMetadata(date);
    }
}
