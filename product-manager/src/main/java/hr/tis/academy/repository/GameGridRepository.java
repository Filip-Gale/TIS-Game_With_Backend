package hr.tis.academy.repository;

import hr.tis.academy.model.GameGrid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameGridRepository extends JpaRepository<GameGrid, Long> {
}
