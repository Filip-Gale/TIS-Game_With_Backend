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
    private List<Skills> skills;

    @ManyToOne
    @JoinColumn(name = "GAME_GRID_ID")
    private GameGrid gameGrid;

    @ManyToOne
    @JoinColumn(name = "GAME_BOARD_ID")
    private GameBoard gameBoard;
}
