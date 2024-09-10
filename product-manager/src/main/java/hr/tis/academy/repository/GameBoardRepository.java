package hr.tis.academy.repository;

import hr.tis.academy.model.GameBoard;
import hr.tis.academy.model.dto.GameBoardDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameBoardRepository extends JpaRepository<GameBoard, Long> {
    GameBoard finByDuckyUsersId(Long duckyUsersId);
}
