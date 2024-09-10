package hr.tis.academy.model;

import hr.tis.academy.dto.GameObjectsDTO;
import hr.tis.academy.enums.TerrainType;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

import java.util.List;

@Entity
@Table(name = "GAME_GRID", schema = "QUACKY")
public class GameGrid {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column
    @Min(3)
    @Max(8)
    private Integer gridSize;

    @Enumerated(EnumType.STRING)
    private TerrainType terrainType;

    @OneToMany(mappedBy = "gameGrid")
    private List<GameObjects> gameObjects;

    @OneToMany(mappedBy = "gameGrid", fetch = FetchType.EAGER)
    private List<GameBoard> gameBoards;

    public GameGrid() {}

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public @Min(3) @Max(8) Integer getGridSize() {
        return gridSize;
    }

    public void setGridSize(@Min(3) @Max(8) Integer gridSize) {
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
