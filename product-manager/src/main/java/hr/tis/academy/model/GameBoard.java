package hr.tis.academy.model;

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
}
