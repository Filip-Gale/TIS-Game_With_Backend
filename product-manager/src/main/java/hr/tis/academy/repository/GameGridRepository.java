package hr.tis.academy.repository;

import hr.tis.academy.model.GameGrid;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface GameGridRepository extends JpaRepository<GameGrid, Long> {
    @Query(nativeQuery = true, value = "SELECT * FROM QUACKY.GAME_GRID ORDER BY RANDOM() LIMIT 1")
    GameGrid getRandomGrid();
}
