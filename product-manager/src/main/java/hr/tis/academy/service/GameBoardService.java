package hr.tis.academy.service;

import hr.tis.academy.model.GameGrid;
import hr.tis.academy.model.GameObjects;
import hr.tis.academy.model.dto.GameBoardDto;

public interface GameBoardService {
    GameGrid findGameGridByUserId(Long userId);
    GameObjects getBoardTileDetail(Integer x, Integer y, Long userId);
}
