package hr.tis.academy.repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;

public class ProductRepositoryInMemory implements  ProductRepository{

    //private static final List<ProductsMetadata> productsMetadataList = new ArrayList<>();.

    @Override
    public BigDecimal fetchSumOfPrices(LocalDate createdDate) {
        return null;
    }

    @Override
    public BigDecimal fetchSumOfPrices(Long id) {
        return null;
    }

    @Override
    public Integer fetchProductsMetadataCount() {
        return 0;
    }
}
