package hr.tis.academy.service;
import hr.tis.academy.model.ProductsMetadata;
import java.time.LocalDate;

public interface ProductService {

    ProductsMetadata fetchProductsFromWeb();
    ProductsMetadata saveProductsFromWeb();
    ProductsMetadata getProductsForDate(LocalDate date);
}
