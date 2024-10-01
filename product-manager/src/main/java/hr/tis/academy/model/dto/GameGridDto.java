package hr.tis.academy.model.dto;

import hr.tis.academy.model.enums.TerrainType;
import hr.tis.academy.model.GameBoard;
import hr.tis.academy.model.GameObjects;

import java.util.List;

public class GameGridDto {

    private Long Id;

    private Integer gridSize;

    private TerrainType terrainType;

    private List<GameObjects> gameObjects;

    private List<GameBoard> gameBoards;

    public GameGridDto() {}

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Integer getGridSize() {
        return gridSize;
    }

    public void setGridSize(Integer gridSize) {
        this.gridSize = gridSize;
    }

    public TerrainType getTerrainType() {
        return terrainType;
    }

    public void setTerrainType(TerrainType terrainType) {
        this.terrainType = terrainType;
    }

    public List<GameObjects> getGameObjects() {
        return gameObjects;
    }

    public void setGameObjects(List<GameObjects> gameObjects) {
        this.gameObjects = gameObjects;
    }

    public List<GameBoard> getGameBoards() {
        return gameBoards;
    }

    public void setGameBoards(List<GameBoard> gameBoards) {
        this.gameBoards = gameBoards;
    }
}
