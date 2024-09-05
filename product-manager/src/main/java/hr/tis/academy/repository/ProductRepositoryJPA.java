package hr.tis.academy.repository;

import hr.tis.academy.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface ProductRepositoryJPA extends JpaRepository<Product, Long> {
    //Product findByNameAndScore(String name, int score);
    //@Query("select p from Product p where p.name = :name and p.score = :score")
    //Product fetchByNameAndScoreJPQL(String name, int score);
    @Query(nativeQuery = true, value = "SELECT * FROM PRODUCT_MANAGER.PRODUCT p WHERE p.NAME = :name AND " +
            "p.SCORE = :score")
    Product findByNameAndScoreNative(String name, int score);
    //@Query("select avg(p.score) from Product p where p.productsMetadata.id = :id")
    //BigDecimal getAverageScoreJPQL(Long id);
    @Query("select avg(p.score) from Product p where p.productsMetadata.id = :id")
    Integer getAverageScoreJPQL(Long id);
}
