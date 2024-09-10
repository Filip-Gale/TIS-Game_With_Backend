package hr.tis.academy.service.impl;

import hr.tis.academy.model.GameBoard;
import hr.tis.academy.model.GameGrid;
import hr.tis.academy.model.GameObjects;
import hr.tis.academy.model.dto.GameBoardDto;
import hr.tis.academy.repository.GameBoardRepository;
import hr.tis.academy.repository.GameGridRepository;
import hr.tis.academy.service.GameBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameBoardServiceImpl implements GameBoardService {

    private final GameBoardRepository gameBoardRepository;
    private final GameGridRepository gameGridRepository;

    @Autowired
    public GameBoardServiceImpl(GameBoardRepository gameBoardRepository, GameGridRepository gameGridRepository) {
        this.gameBoardRepository = gameBoardRepository;
        this.gameGridRepository = gameGridRepository;
    }

    @Override
    public GameGrid findGameGridByUserId(Long userId) {
        GameBoard gameBoard = gameBoardRepository.finByDuckyUsersId(userId);
        return gameBoard.getGameGrid();
    }

    @Override
    public GameObjects getBoardTileDetail(Integer x, Integer y, Long userId) {
        return null;
    }
}
