package hr.tis.academy.model.dto;

import hr.tis.academy.model.enums.GameState;
import hr.tis.academy.model.DuckyUsers;
import hr.tis.academy.model.GameGrid;
import hr.tis.academy.model.GameLog;
import hr.tis.academy.model.GameObjects;

import java.time.LocalDateTime;
import java.util.List;

public class GameBoardDto {
    private Long Id;

    private GameState gameState;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    private DuckyUsers duckyUsers;

    private GameGrid gameGrid;

    private List<GameObjects> gameObjects;

    private  List<GameLog> gameLogs;

    public GameBoardDto() {}

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public DuckyUsers getDuckyUsers() {
        return duckyUsers;
    }

    public void setDuckyUsers(DuckyUsers duckyUsers) {
        this.duckyUsers = duckyUsers;
    }

    public GameGrid getGameGrid() {
        return gameGrid;
    }

    public void setGameGrid(GameGrid gameGrid) {
        this.gameGrid = gameGrid;
    }

    public List<GameObjects> getGameObjects() {
        return gameObjects;
    }

    public void setGameObjects(List<GameObjects> gameObjects) {
        this.gameObjects = gameObjects;
    }

    public List<GameLog> getGameLogs() {
        return gameLogs;
    }

    public void setGameLogs(List<GameLog> gameLogs) {
        this.gameLogs = gameLogs;
    }
}
