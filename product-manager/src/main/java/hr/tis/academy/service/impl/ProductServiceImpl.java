package hr.tis.academy.service.impl;

import hr.tis.academy.model.ProductsMetadata;
import hr.tis.academy.scraper.WebScraper;
import hr.tis.academy.service.ProductService;

import java.time.LocalDate;

public class ProductServiceImpl implements ProductService {
    private final WebScraper webScraper = new WebScraper();
    @Override
    public ProductsMetadata fetchProductsFromWeb() {
        return webScraper.fetchProducts();
    }

    @Override
    public ProductsMetadata saveProductsFromWeb() {
        ProductsMetadata productsMetadata = webScraper.fetchProducts();
        return null;
    }

    @Override
    public ProductsMetadata getProductsForDate(LocalDate date) {
        return null;
    }
}
