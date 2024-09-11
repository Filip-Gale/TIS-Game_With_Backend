package hr.tis.academy.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import hr.tis.academy.enums.GameState;
import jakarta.persistence.*;

import java.security.PrivateKey;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "GAME_BOARD", schema = "QUACKY")
public class GameBoard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Enumerated(EnumType.STRING)
    private GameState gameState;

    @Column
    private LocalDateTime startTime;

    @Column
    private LocalDateTime endTime;

    @ManyToOne
    @JoinColumn(name = "DUCKY_USERS_ID")
    private DuckyUsers duckyUsers;

    @ManyToOne
    @JoinColumn(name = "GAME_GRID_ID")
    private GameGrid gameGrid;

    @OneToMany(mappedBy = "gameBoard")
    private List<GameObjects> gameObjects;

    @OneToMany(mappedBy = "gameBoard")
    private  List<GameLog> gameLogs;

    public GameBoard() {}

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
