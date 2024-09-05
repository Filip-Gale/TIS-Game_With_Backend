package hr.tis.academy.repository;

import hr.tis.academy.model.Address;
import hr.tis.academy.model.ProductsMetadata;
import hr.tis.academy.model.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
@Repository
public interface StoreRepository extends JpaRepository<Store, Long> {
    Store findByStoreNameAndEmail(String name, String mail);

    @Query("select s from Store s where s.storeName = :name and s.email = :mail")
    Store fetchByStoreNameAndEmailJPQL(String name, String mail);

    @Query(nativeQuery = true, value = "SELECT * FROM PRODUCT_MANAGER.STORE s WHERE s.STORE_NAME = :name AND " +
            "s.EMAIL = :mail")
    Store fetchByStoreNameAndEmailNative(String name, String mail);

    @Query(nativeQuery = true, value = "SELECT * FROM PRODUCT_MANAGER.STORE s " +
            "WHERE s.EMAIL = :mail")
    Store fetchStoreRecord(String mail);
}
