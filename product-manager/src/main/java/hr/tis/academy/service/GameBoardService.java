package hr.tis.academy.service;

import hr.tis.academy.dto.GameObjectsDTO;
import hr.tis.academy.model.dto.GameGridDto;
import hr.tis.academy.model.dto.GameHistoryDto;
import hr.tis.academy.model.dto.GameStateDto;

import java.time.LocalDateTime;
import java.util.List;

public interface GameBoardService {
    GameGridDto findGameGridByUserId(Long userId);
    GameObjectsDTO getBoardTileDetail(Integer x, Integer y, Long userId);
    List<GameHistoryDto> getGameBoardsForInterval(LocalDateTime start, LocalDateTime end);
    void updateGameState(GameStateDto gameStateDto);
}
