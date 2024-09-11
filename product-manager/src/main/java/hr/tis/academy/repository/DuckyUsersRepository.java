package hr.tis.academy.repository;

import hr.tis.academy.model.DuckyUsers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DuckyUsersRepository extends JpaRepository<DuckyUsers, Integer> {
}
