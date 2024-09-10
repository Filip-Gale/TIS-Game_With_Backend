package hr.tis.academy.service.impl;

import hr.tis.academy.dto.GameObjectsDTO;
import hr.tis.academy.enums.EntityType;
import hr.tis.academy.enums.GameState;
import hr.tis.academy.enums.TerrainType;
import hr.tis.academy.model.GameBoard;
import hr.tis.academy.model.GameGrid;
import hr.tis.academy.model.GameObjects;
import hr.tis.academy.model.dto.GameGridDto;
import hr.tis.academy.repository.DuckyUserRepository;
import hr.tis.academy.repository.GameBoardRepository;
import hr.tis.academy.repository.GameGridRepository;
import hr.tis.academy.repository.GameObjectsRepository;
import hr.tis.academy.service.GameBoardService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class GameBoardServiceImpl implements GameBoardService {

    private final GameBoardRepository gameBoardRepository;
    private final DuckyUserRepository duckyUserRepository;
    private final GameGridRepository gameGridRepository;
    private final GameObjectsRepository gameObjectsRepository;

    @PostConstruct
    public void init() {
        GameGrid gameGrid = new GameGrid();

        List<GameObjects> gameObjectsList = new ArrayList<>();

        GameObjects gameObjects = new GameObjects(0,0,5,null,EntityType.HOLE);
        GameObjects gameObjects2 = new GameObjects(1,0,5,null,EntityType.HOLE);
        GameObjects gameObjects3 = new GameObjects(2,0,5,null,EntityType.TILE);
        GameObjects gameObjects4 = new GameObjects(0,1,5,null,EntityType.TILE);
        GameObjects gameObjects5 = new GameObjects(1,1,5,null,EntityType.TILE);
        GameObjects gameObjects6 = new GameObjects(2,1,5,null,EntityType.TILE);
        GameObjects gameObjects7 = new GameObjects(0,2,5,null,EntityType.TILE);
        GameObjects gameObjects8 = new GameObjects(1,2,5,null,EntityType.TILE);
        GameObjects gameObjects9 = new GameObjects(2,2,5,null,EntityType.TILE);
        GameObjects gameObjects10 = new GameObjects(0,0,5,5,EntityType.MAIN_CHARACTER);
        GameObjects gameObjects11 = new GameObjects(2,2,5,3,EntityType.ENEMY);
        GameObjects gameObjects12 = new GameObjects(1,1,5,3,EntityType.EGG);

        gameObjectsList.add(gameObjects);
        gameObjectsList.add(gameObjects2);
        gameObjectsList.add(gameObjects3);
        gameObjectsList.add(gameObjects4);
        gameObjectsList.add(gameObjects5);
        gameObjectsList.add(gameObjects6);
        gameObjectsList.add(gameObjects7);
        gameObjectsList.add(gameObjects8);
        gameObjectsList.add(gameObjects9);
        gameObjectsList.add(gameObjects10);
        gameObjectsList.add(gameObjects11);
        gameObjectsList.add(gameObjects12);

        gameObjectsRepository.saveAll(gameObjectsList);

        gameGrid.setGridSize(3);
        gameGrid.setTerrainType(TerrainType.DESERT_2);
        gameGrid.setGameObjects(gameObjectsList);

        gameGridRepository.save(gameGrid);

        GameBoard gameBoard = new GameBoard();
        gameBoard.setGameGrid(gameGrid);
        gameBoard.setDuckyUsers(duckyUserRepository.findByUserName("Gale"));
        gameBoard.setGameObjects(gameGrid.getGameObjects());
        gameBoard.setGameState(GameState.GAME_OVER_WIN);
        gameBoard.setStartTime(LocalDateTime.now());
        gameBoard.setEndTime(LocalDateTime.now());
        gameBoardRepository.save(gameBoard);
    }

    @Autowired
    public GameBoardServiceImpl(GameBoardRepository gameBoardRepository, DuckyUserRepository duckyUserRepository, GameGridRepository gameGridRepository, GameObjectsRepository gameObjectsRepository) {
        this.gameBoardRepository = gameBoardRepository;
        this.duckyUserRepository = duckyUserRepository;
        this.gameGridRepository = gameGridRepository;
        this.gameObjectsRepository = gameObjectsRepository;
    }

    public GameGridDto gameGridToGameGridDto(GameGrid gameGrid) {
        GameGridDto gameGridDTO = new GameGridDto();
        gameGridDTO.setId(gameGrid.getId());
        gameGridDTO.setGameObjects(gameGrid.getGameObjects());
        gameGridDTO.setGridSize(gameGrid.getGridSize());
        gameGridDTO.setGameBoards(gameGrid.getGameBoards());
        gameGridDTO.setTerrainType(gameGrid.getTerrainType());
        return  gameGridDTO;
    }

    @Override
    public GameGridDto findGameGridByUserId(Long userId) {
        return  gameGridToGameGridDto( gameBoardRepository.findByDuckyUsersId(userId).getGameGrid());
    }

    @Override
    public GameObjectsDTO getBoardTileDetail(Integer x, Integer y, Long userId) {
        GameObjects selectedGameObjects = new GameObjects();
        GameBoard gameBoard = gameBoardRepository.findByDuckyUsersIdAndGameState(userId, GameState.GAME_IN_PROGRESS);
        for(GameObjects gameObject : gameBoard.getGameObjects()) {
            System.out.println(gameObject.getX() + " " + gameObject.getY() + " " + gameObject.getEntityType());
            if(gameObject.getX().equals(x) && gameObject.getY().equals(y)) {
                if (selectedGameObjects.getEntityType().equals(EntityType.EMPTY)) {
                    selectedGameObjects = gameObject;
                }
                if (selectedGameObjects.getEntityType().equals(EntityType.TILE) || selectedGameObjects.getEntityType().equals(EntityType.HOLE)) {
                    selectedGameObjects = gameObject;
                }
            }
        }
        return selectedGameObjects.toDTO();
    }
}
