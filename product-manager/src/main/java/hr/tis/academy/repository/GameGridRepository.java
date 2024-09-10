package hr.tis.academy.repository;

import hr.tis.academy.model.GameGrid;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameGridRepository extends JpaRepository<GameGrid, Long> {
}
