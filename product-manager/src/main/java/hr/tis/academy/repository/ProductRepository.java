package hr.tis.academy.repository;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface ProductRepository {
    //Long insertProducts(ProductsMetadata ProductsMetadata);
    BigDecimal fetchSumOfPrices(LocalDate createdDate);

    BigDecimal fetchSumOfPrices(Long id);
    //ProductsMetadata fetchProductsMetadata(LocalDate createdDate);
    //ProductsMetadata fetchProductsMetadata(Long id);
    Integer fetchProductsMetadataCount();
// dodati i implementirati defaultnu metodu
// BigDecimal calculateSumOfPrices(List<Product> products)
}
