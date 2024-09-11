package hr.tis.academy.repository;

import hr.tis.academy.model.DuckyUsers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DuckyUserRepository extends JpaRepository<DuckyUsers, Long> {
    DuckyUsers findByUserName(String username);
}
