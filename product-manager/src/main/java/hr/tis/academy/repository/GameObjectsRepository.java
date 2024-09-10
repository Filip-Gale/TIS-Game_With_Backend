package hr.tis.academy.repository;

import hr.tis.academy.model.GameObjects;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameObjectsRepository extends JpaRepository<Long, GameObjects>{
    
}
