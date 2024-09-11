package hr.tis.academy.model;

import hr.tis.academy.enums.EntityType;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "GAME_OBJECTS", schema = "QUACKY")
public class GameObjects {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Integer x;

    @Column
    private Integer y;

    @Column
    private Integer moveDistance;

    @Column
    private Integer health;

    @Enumerated(EnumType.STRING)
    private EntityType entityType;

    @ManyToMany
    @JoinTable(schema = "QUACKY")
    private List<Skills> skills;

    @ManyToOne
    @JoinColumn(name = "GAME_GRID_ID")
    private GameGrid gameGrid;

    @ManyToOne
    @JoinColumn(name = "GAME_BOARD_ID")
    private GameBoard gameBoard;

    public GameObjects() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public Integer getMoveDistance() {
        return moveDistance;
    }

    public void setMoveDistance(Integer moveDistance) {
        this.moveDistance = moveDistance;
    }

    public Integer getHealth() {
        return health;
    }

    public void setHealth(Integer health) {
        this.health = health;
    }

    public EntityType getEntityType() {
        return entityType;
    }

    public void setEntityType(EntityType entityType) {
        this.entityType = entityType;
    }

    public List<Skills> getSkills() {
        return skills;
    }

    public void setSkills(List<Skills> skills) {
        this.skills = skills;
    }

    public GameGrid getGameGrid() {
        return gameGrid;
    }

    public void setGameGrid(GameGrid gameGrid) {
        this.gameGrid = gameGrid;
    }

    public GameBoard getGameBoard() {
        return gameBoard;
    }

    public void setGameBoard(GameBoard gameBoard) {
        this.gameBoard = gameBoard;
    }
}
