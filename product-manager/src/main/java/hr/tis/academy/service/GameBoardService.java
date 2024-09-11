package hr.tis.academy.service;

import hr.tis.academy.model.dto.GameHistoryDto;
import hr.tis.academy.model.dto.GameStateDto;

import java.time.LocalDateTime;
import java.util.List;

public interface GameBoardService {
    List<GameHistoryDto> getGameBoardsForInterval(LocalDateTime start, LocalDateTime end);
    void updateGameState(GameStateDto gameStateDto);
}
