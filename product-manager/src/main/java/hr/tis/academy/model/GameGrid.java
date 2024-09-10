package hr.tis.academy.model;

import hr.tis.academy.enums.TerrainType;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "GAME_GRID", schema = "QUACKY")
public class GameGrid {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column
    private Integer gridSize;

    @Enumerated(EnumType.STRING)
    private TerrainType terrainType;

    @OneToMany(mappedBy = "gameGrid")
    private List<GameObjects> gameObjects;

    @OneToMany(mappedBy = "gameGrid")
    private List<GameBoard> gameBoards;

    public GameGrid() {}
}
