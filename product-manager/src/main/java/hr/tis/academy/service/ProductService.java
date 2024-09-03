package hr.tis.academy.service;
import hr.tis.academy.dto.ProductsMetadataDto;
import hr.tis.academy.model.ProductsMetadata;
import java.time.LocalDate;

public interface ProductService {

    ProductsMetadataDto fetchProductsFromWeb();
    ProductsMetadataDto saveProductsFromWeb();
    ProductsMetadataDto getProductsForDate(LocalDate date);
}
