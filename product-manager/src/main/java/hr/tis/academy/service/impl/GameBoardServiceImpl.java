package hr.tis.academy.service.impl;

import hr.tis.academy.dto.GameObjectsDTO;
import hr.tis.academy.enums.EntityType;
import hr.tis.academy.enums.GameState;
import hr.tis.academy.enums.TerrainType;
import hr.tis.academy.file.LogWriter;
import hr.tis.academy.model.GameBoard;
import hr.tis.academy.model.GameGrid;
import hr.tis.academy.model.GameObjects;
import hr.tis.academy.model.dto.GameBoardDto;
import hr.tis.academy.model.dto.GameGridDto;
import hr.tis.academy.model.dto.GameHistoryDto;
import hr.tis.academy.model.dto.GameStateDto;
import hr.tis.academy.repository.DuckyUserRepository;
import hr.tis.academy.repository.GameBoardRepository;
import hr.tis.academy.repository.GameGridRepository;
import hr.tis.academy.repository.GameObjectsRepository;
import hr.tis.academy.service.GameBoardService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GameBoardServiceImpl implements GameBoardService {

    private final GameBoardRepository gameBoardRepository;
    private final DuckyUserRepository duckyUserRepository;
    private final GameGridRepository gameGridRepository;
    private final GameObjectsRepository gameObjectsRepository;

    private static final String LOG_FILE = LogWriter.LOG_DIRECTORY + "/game_history.txt";
    private final LogWriter logWriter;

//    @PostConstruct
//    public void init() {
//        GameGrid gameGrid = new GameGrid();
//
//        List<GameObjects> gameObjectsList = new ArrayList<>();
//
//        GameObjects gameObjects = new GameObjects(0,0,5,null,EntityType.HOLE);
//        GameObjects gameObjects2 = new GameObjects(1,0,5,null,EntityType.HOLE);
//        GameObjects gameObjects3 = new GameObjects(2,0,5,null,EntityType.TILE);
//        GameObjects gameObjects4 = new GameObjects(0,1,5,null,EntityType.TILE);
//        GameObjects gameObjects5 = new GameObjects(1,1,5,null,EntityType.TILE);
//        GameObjects gameObjects6 = new GameObjects(2,1,5,null,EntityType.TILE);
//        GameObjects gameObjects7 = new GameObjects(0,2,5,null,EntityType.TILE);
//        GameObjects gameObjects8 = new GameObjects(1,2,5,null,EntityType.TILE);
//        GameObjects gameObjects9 = new GameObjects(2,2,5,null,EntityType.TILE);
//        GameObjects gameObjects10 = new GameObjects(0,0,5,5,EntityType.MAIN_CHARACTER);
//        GameObjects gameObjects11 = new GameObjects(2,2,5,3,EntityType.ENEMY);
//        GameObjects gameObjects12 = new GameObjects(1,1,5,3,EntityType.EGG);
//
//        gameObjectsList.add(gameObjects);
//        gameObjectsList.add(gameObjects2);
//        gameObjectsList.add(gameObjects3);
//        gameObjectsList.add(gameObjects4);
//        gameObjectsList.add(gameObjects5);
//        gameObjectsList.add(gameObjects6);
//        gameObjectsList.add(gameObjects7);
//        gameObjectsList.add(gameObjects8);
//        gameObjectsList.add(gameObjects9);
//        gameObjectsList.add(gameObjects10);
//        gameObjectsList.add(gameObjects11);
//        gameObjectsList.add(gameObjects12);
//
//        gameObjectsRepository.saveAll(gameObjectsList);
//
//        gameGrid.setGridSize(3);
//        gameGrid.setTerrainType(TerrainType.DESERT_2);
//        gameGrid.setGameObjects(gameObjectsList);
//
//        GameBoard gameBoard = new GameBoard();
//        gameBoard.setGameGrid(gameGrid);
//        gameBoard.setDuckyUsers(duckyUserRepository.findByUserName("Gale"));
//        gameBoard.setGameObjects(gameGrid.getGameObjects());
//        gameBoard.setGameState(GameState.GAME_OVER_WIN);
//        gameBoard.setStartTime(LocalDateTime.now());
//        gameBoard.setEndTime(LocalDateTime.now());
//        gameBoardRepository.save(gameBoard);
//    }

    @Autowired
    public GameBoardServiceImpl(GameBoardRepository gameBoardRepository, DuckyUserRepository duckyUserRepository, GameGridRepository gameGridRepository, GameObjectsRepository gameObjectsRepository, LogWriter logWriter) {
        this.gameBoardRepository = gameBoardRepository;
        this.duckyUserRepository = duckyUserRepository;
        this.gameGridRepository = gameGridRepository;
        this.gameObjectsRepository = gameObjectsRepository;
        this.logWriter = logWriter;
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
        if(gameBoardRepository.existsGameBoardByDuckyUsersIdAndGameState(userId, GameState.GAME_IN_PROGRESS)){
            GameBoard gameBoard = gameBoardRepository.findByDuckyUsersId(userId);
            GameGridDto gameGridDto = new GameGridDto();
            gameGridDto.setGridSize(gameBoard.getGameGrid().getGridSize());
            gameGridDto.setGameObjects(gameBoard.getGameObjects());
            gameGridDto.setTerrainType(gameBoard.getGameGrid().getTerrainType());
            return  gameGridDto;
        }
        else {
            GameGrid gameGrid = gameGridRepository.getRandomGrid();
            GameBoard gameBoard = new GameBoard();
            gameBoard.setStartTime(LocalDateTime.now());
            gameBoard.setGameState(GameState.GAME_IN_PROGRESS);
            gameBoard.setDuckyUsers(duckyUserRepository.findById(userId).get());
            gameBoard.setGameGrid(gameGrid);

            GameBoard createdGameBoard = gameBoardRepository.save(gameBoard);

            List<GameObjects> gameBoardGameObjects = new ArrayList<>();
            for(GameObjects gameobject : gameGrid.getGameObjects()) {
                GameObjects gameObjects = new GameObjects();
                gameObjects.setX(gameobject.getX());
                gameObjects.setY(gameobject.getY());
                gameObjects.setHealth(gameobject.getHealth());
                gameObjects.setMoveDistance(gameobject.getMoveDistance());
                gameObjects.setEntityType(gameobject.getEntityType());
                gameObjects.setSkills(new ArrayList<>(gameobject.getSkills()));
                gameObjects.setGameBoard(createdGameBoard);
                gameObjects.setGameGrid(null);
                gameBoardGameObjects.add(gameObjects);
            }
            List<GameObjects> gameObjectsList = gameObjectsRepository.saveAll(gameBoardGameObjects);

            GameGridDto gameGridDto = new GameGridDto();
            gameGridDto.setGridSize(createdGameBoard.getGameGrid().getGridSize());
            gameGridDto.setTerrainType(createdGameBoard.getGameGrid().getTerrainType());
            gameGridDto.setGameObjects(gameObjectsList);
            return  gameGridDto;
        }
    }

    @Override
    public GameObjectsDTO getBoardTileDetail(Integer x, Integer y, Long userId) {
        GameObjects selectedGameObjects = new GameObjects();
        GameBoard gameBoard = gameBoardRepository.findByDuckyUsersIdAndGameState(userId, GameState.GAME_IN_PROGRESS);
        List<GameObjects> gameObjectsList = gameObjectsRepository.findByGameBoardIdAndXAndY(gameBoard.getId(),x,y);
        if(gameObjectsList.size() == 1){
            selectedGameObjects = gameObjectsList.get(0);
        }

        else {
            for(GameObjects gameobject : gameObjectsList) {
                if(!gameobject.getEntityType().equals(EntityType.TILE) && !gameobject.getEntityType().equals(EntityType.HOLE)){
                    selectedGameObjects = gameobject;
                }
            }
        }
        return selectedGameObjects.toDTO();
    }

    @Override
    public List<GameHistoryDto> getGameBoardsForInterval(LocalDateTime start, LocalDateTime end) {
        List<GameBoard> gameBoards = gameBoardRepository.findGameBoardsInInterval(start, end);
        List<GameHistoryDto> gameHistoryDtoList = gameBoards.stream()
                .map(gameBoard -> {
                    String gameState = String.valueOf(gameBoard.getGameState());
                    long matchLength = Duration.between(gameBoard.getStartTime(), gameBoard.getEndTime()).toMinutes();
                    String matchLengthString = String.format("%d min", matchLength);
                    String userName = gameBoard.getDuckyUsers() != null ? gameBoard.getDuckyUsers().getUserName() : "Unknown";
                    return new GameHistoryDto(gameState, matchLengthString, userName);
                })
                .collect(Collectors.toList());

        String history = "";
        for(GameHistoryDto gameHistoryDto : gameHistoryDtoList) {
            history = "UserName: " + gameHistoryDto.userName() + ", " + "Match length: " + gameHistoryDto.matchLength() + ", " +
                    "Game State: " + gameHistoryDto.gameState();
        }
        logWriter.writeLogToFile(history, LOG_FILE);
        return gameHistoryDtoList;
    }

    @Override
    public void updateGameState(GameStateDto gameStateDto) {
        GameState newGameState = gameStateDtoToGameState(gameStateDto);
        GameBoard gameBoard = gameBoardRepository.findGameBoardByGameStateAndDuckyUsersId(GameState.GAME_IN_PROGRESS, gameStateDto.getUserId());

        if(gameBoard != null) {
            gameBoard.setGameState(newGameState);
            gameBoardRepository.save(gameBoard);
        }
    }

    public GameState gameStateDtoToGameState(GameStateDto gameStateDto) {
        return GameState.valueOf(gameStateDto.getGameState().name());
    }
}
