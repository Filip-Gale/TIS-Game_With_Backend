package hr.tis.academy.service.impl;

import hr.tis.academy.dto.ProductsMetadataDto;
import hr.tis.academy.mappers.ProductsMetadataMapper;
import hr.tis.academy.model.ProductsMetadata;
import hr.tis.academy.repository.ProductRepository;
import hr.tis.academy.repository.ProductRepositoryInMemory;
import hr.tis.academy.repository.ProductsMetadataRepository;
import hr.tis.academy.scraper.WebScraper;
import hr.tis.academy.service.ProductService;
import org.hibernate.annotations.CollectionTypeRegistration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductsMetadataRepository productsMetadataRepository;
    private final ProductsMetadataMapper productsMetadataMapper;
    private final WebScraper webScraper;


    @Autowired
    public ProductServiceImpl(ProductsMetadataRepository productsMetadataRepository,
                              ProductsMetadataMapper productsMetadataMapper,
                              WebScraper webScraper) {
        this.productsMetadataMapper = productsMetadataMapper;
        this.webScraper = webScraper;
        this.productsMetadataRepository = productsMetadataRepository;
    }
    @Override
    public ProductsMetadataDto fetchProductsFromWeb() {
        return productsMetadataMapper.toDto(webScraper.fetchProducts());
    }

    @Override
    public ProductsMetadataDto saveProductsFromWeb() {
        ProductsMetadata productsMetadata = webScraper.fetchProducts();
        //productRepository.insertProducts(productsMetadata);
        productsMetadataRepository.save(productsMetadata);
        return null;
    }

    @Override
    public ProductsMetadataDto getProductsForDate(LocalDate date) {
        //return productsMetadataMapper.toDto(productRepository.fetchProductsMetadata(date));
        return productsMetadataMapper.toDto(productsMetadataRepository.fetchProductsRecord(date.atStartOfDay()));
    }
}
