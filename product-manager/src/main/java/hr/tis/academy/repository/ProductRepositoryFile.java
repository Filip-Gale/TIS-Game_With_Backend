package hr.tis.academy.repository;

import hr.tis.academy.file.FileSystemConfiguration;
import hr.tis.academy.file.ProductReader;
import hr.tis.academy.file.ProductWriter;
import hr.tis.academy.model.Product;
import hr.tis.academy.model.ProductsMetadata;
import hr.tis.academy.repository.exception.NoProductFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.io.File;
import java.math.BigDecimal;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.*;

@Component
@Profile("file")
public class ProductRepositoryFile implements ProductRepository {
    @Autowired
    @Qualifier("getPath")
    private Path filePath;

    private final File directory = filePath.toFile();

    @Override
    public Long insertProducts(ProductsMetadata productsMetadata) {

        long newId = Arrays.stream(Objects.requireNonNull(directory.listFiles()))
                .count() + 1;
        productsMetadata.setId(newId);
        ProductWriter.writeProducts(productsMetadata);

        return productsMetadata.getId();
    }

    @Override
    public BigDecimal fetchSumOfPrices(LocalDate createdDate) {
        ProductsMetadata temp = fetchProductsMetadata(createdDate);
        return calculateSumOfPrices(temp.getProducts());
    }

    @Override
    public BigDecimal fetchSumOfPrices(Long id) {

        Optional<ProductsMetadata> metadata = Arrays.stream(Objects.requireNonNull(directory.listFiles()))
                .map(file -> ProductReader.read(file.getName()))
                .filter(pm -> pm.getId().equals(id))
                .findFirst();

        return metadata
                .map(md -> calculateSumOfPrices(md.getProducts()))
                .orElse(BigDecimal.ZERO);

    }

    @Override
    public ProductsMetadata fetchProductsMetadata(LocalDate createdDate) {
        return Arrays.stream(Objects.requireNonNull(directory.listFiles()))
                .map(file -> ProductReader.read(file.getName()))
                .filter(pm -> pm.getCreationDateTime().toLocalDate().isEqual(createdDate))
                .max(Comparator.comparing(ProductsMetadata::getCreationDateTime))
                .orElseThrow(() -> new NoProductFoundException("No product found for " + createdDate));
    }

    @Override
    public ProductsMetadata fetchProductsMetadata(Long id) {
        return Arrays.stream(Objects.requireNonNull(directory.listFiles()))
                .map(file -> ProductReader.read(file.getName()))
                .filter(pm -> pm.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("No ProductsMetadata found with id: " + id));
    }

    @Override
    public Integer fetchProductsMetadataCount() {
        return Math.toIntExact(Arrays.stream(Objects.requireNonNull(directory.listFiles()))
                .count());
    }

    @Override
    public BigDecimal calculateSumOfPrices(List<Product> products) {

        return products.stream()
                .map(Product::getPrice)
                .peek(price -> System.out.println("Individual price: " + price))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
