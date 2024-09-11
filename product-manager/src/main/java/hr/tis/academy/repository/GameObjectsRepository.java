package hr.tis.academy.repository;

import hr.tis.academy.model.GameObjects;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameObjectsRepository extends JpaRepository<GameObjects, Long> {

}
