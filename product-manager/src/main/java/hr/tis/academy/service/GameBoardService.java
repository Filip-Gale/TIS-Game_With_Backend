package hr.tis.academy.service;

import hr.tis.academy.dto.GameObjectsDTO;
import hr.tis.academy.model.dto.GameGridDto;

public interface GameBoardService {
    GameGridDto findGameGridByUserId(Long userId);
    GameObjectsDTO getBoardTileDetail(Integer x, Integer y, Long userId);
}
