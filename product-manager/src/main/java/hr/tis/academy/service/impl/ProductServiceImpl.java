package hr.tis.academy.service.impl;

import hr.tis.academy.dto.ProductsMetadataDto;
import hr.tis.academy.mappers.ProductsMetadataMapper;
import hr.tis.academy.model.ProductsMetadata;
import hr.tis.academy.repository.ProductRepository;
import hr.tis.academy.repository.ProductRepositoryInMemory;
import hr.tis.academy.scraper.WebScraper;
import hr.tis.academy.service.ProductService;
import org.hibernate.annotations.CollectionTypeRegistration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductsMetadataMapper productsMetadataMapper;
    private final WebScraper webScraper;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, ProductsMetadataMapper productsMetadataMapper, WebScraper webScraper) {
        this.productRepository = productRepository;
        this.productsMetadataMapper = productsMetadataMapper;
        this.webScraper = webScraper;
    }
    @Override
    public ProductsMetadataDto fetchProductsFromWeb() {
        return productsMetadataMapper.toDto(webScraper.fetchProducts());
    }

    @Override
    public ProductsMetadataDto saveProductsFromWeb() {
        ProductsMetadata productsMetadata = webScraper.fetchProducts();
        productRepository.insertProducts(productsMetadata);
        return null;
    }

    @Override
    public ProductsMetadataDto getProductsForDate(LocalDate date) {
        return productsMetadataMapper.toDto(productRepository.fetchProductsMetadata(date));
    }
}
