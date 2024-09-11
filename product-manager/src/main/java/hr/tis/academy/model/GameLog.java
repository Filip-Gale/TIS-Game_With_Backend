package hr.tis.academy.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
 @Table(name = "GAME_LOG", schema ="QUACKY")
public class GameLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "GAME_BOARD_ID")
    private GameBoard gameBoard;

    @Column
    private String message;

    @Column
    private Boolean isLegalMove;

    @Column
    private LocalDateTime createdTime;

    public GameLog (){}
}
