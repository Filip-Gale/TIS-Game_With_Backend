package hr.tis.academy.repository;

import hr.tis.academy.model.ProductsMetadata;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ProductsMetadataRepository extends JpaRepository<ProductsMetadata, Long> {
    ProductsMetadata findByTitleAndCreationDateTime(String title, LocalDateTime createdTime);
    @Query("select pm from ProductsMetadata pm where pm.title = :title and pm.creationDateTime = :createdTime")
    ProductsMetadata fetchByTitleAndCreatedTimeJPQL(String title, LocalDateTime createdTime);
    @Query(nativeQuery = true, value = "SELECT * FROM PRODUCT_MANAGER.PRODUCTS_METADATA pm WHERE pm.TITLE = :title AND " +
            "pm.CREATION_DATE_TIME = :createdTime")
    ProductsMetadata fetchByTitleAndCreatedTimeNative(String title, LocalDateTime createdTime);
    @Query(nativeQuery = true, value = "SELECT * FROM PRODUCT_MANAGER.PRODUCTS_METADATA pm " +
            "WHERE pm.CREATION_DATE_TIME BETWEEN :startDate AND :endDate")
    List<ProductsMetadata> fetchProductsRecords(LocalDateTime startDate, LocalDateTime endDate);
    @Query(nativeQuery = true, value = "SELECT * FROM PRODUCT_MANAGER.PRODUCTS_METADATA pm " +
            "WHERE pm.CREATION_DATE_TIME = :date")
    ProductsMetadata fetchProductsRecord(LocalDateTime date);
}
