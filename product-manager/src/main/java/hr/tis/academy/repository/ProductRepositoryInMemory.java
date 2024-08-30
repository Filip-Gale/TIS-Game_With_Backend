package hr.tis.academy.repository;

import hr.tis.academy.model.Product;
import hr.tis.academy.model.ProductsMetadata;
import hr.tis.academy.repository.exception.NoProductFoundException;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ProductRepositoryInMemory implements  ProductRepository{

    private static final List<ProductsMetadata> productsMetadataList = new ArrayList<>();

    @Override
    public Long insertProducts(ProductsMetadata productsMetadata) {

        productsMetadataList.add(productsMetadata);
        //System.out.println("(long)productsMetadataList.size() " + (long)productsMetadataList.size());
        productsMetadata.setId((long)productsMetadataList.size());

        return productsMetadata.getId();
    }

    @Override
    public BigDecimal fetchSumOfPrices(LocalDate createdDate) {

        ProductsMetadata temp = fetchProductsMetadata(createdDate);

        return calculateSumOfPrices(temp.getProducts());
    }

    @Override
    public BigDecimal fetchSumOfPrices(Long id) {
        return  calculateSumOfPrices(productsMetadataList.get(
                Integer.parseInt(String.valueOf(id)))
                .getProducts());
    }

    @Override
    public ProductsMetadata fetchProductsMetadata(LocalDate createdDate) throws NoProductFoundException {
        Optional<ProductsMetadata> temp = productsMetadataList.stream()
                .filter(productsMetadata -> productsMetadata.getCreationDateTime().toLocalDate().equals(createdDate))
                .max(Comparator.comparing(ProductsMetadata::getCreationDateTime))
                .stream()
                .findFirst();

        return temp.orElseThrow(() -> new NoProductFoundException("No product found for " + createdDate));
    }

    @Override
    public ProductsMetadata fetchProductsMetadata(Long id) {
        return productsMetadataList.get(Integer.parseInt(String.valueOf(id)));
    }

    @Override
    public Integer fetchProductsMetadataCount() {
        return productsMetadataList.size();
    }

    @Override
    public BigDecimal calculateSumOfPrices(List<Product> products) {
        BigDecimal sum = BigDecimal.ZERO;

        for (Product p : products) {
            sum = sum.add(p.getPrice());
        }
        return  sum;
    }

    public List<ProductsMetadata> getProductsMetadataList(){
        return productsMetadataList;
    }
}
