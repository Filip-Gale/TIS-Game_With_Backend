package hr.tis.academy.repository;

import hr.tis.academy.enums.GameState;
import hr.tis.academy.model.GameBoard;
import hr.tis.academy.model.dto.GameBoardDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameBoardRepository extends JpaRepository<GameBoard, Long> {
    GameBoard findByDuckyUsersId(Long duckyUsersId);
    GameBoard findByDuckyUsersIdAndGameState(Long duckyUsersId, GameState gameState);
}
