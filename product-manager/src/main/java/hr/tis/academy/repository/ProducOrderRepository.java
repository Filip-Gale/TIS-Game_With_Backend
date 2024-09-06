package hr.tis.academy.repository;

import hr.tis.academy.model.Employee;
import hr.tis.academy.model.ProductsOrder;
import hr.tis.academy.model.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface ProducOrderRepository extends JpaRepository<ProductsOrder, Long> {
    ProductsOrder findByUuid(UUID productId);

    @Query("select po from ProductsOrder po where po.isActive = :isActive")
    List<ProductsOrder> fetchByIsActive(Boolean isActive);
}
