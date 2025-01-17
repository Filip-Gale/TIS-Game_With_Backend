package hr.tis.academy.repository;

import hr.tis.academy.model.enums.GameState;
import hr.tis.academy.model.GameBoard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface GameBoardRepository extends JpaRepository<GameBoard, Long> {
    Boolean existsGameBoardByDuckyUsersIdAndGameState(Long userId, GameState state);
    GameBoard findByDuckyUsersId(Long duckyUsersId);
    GameBoard findByDuckyUsersIdAndGameState(Long duckyUsersId, GameState gameState);
    @Query("SELECT g FROM GameBoard g WHERE g.startTime <= :end AND g.endTime >= :start")
    List<GameBoard> findGameBoardsInInterval(@Param("start") LocalDateTime start, @Param("end") LocalDateTime end);
    GameBoard findGameBoardByGameStateAndDuckyUsersId(GameState gameState, Long id);
}
