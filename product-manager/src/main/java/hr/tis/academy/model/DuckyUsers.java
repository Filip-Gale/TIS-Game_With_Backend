package hr.tis.academy.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "DUCKY_USERS", schema = "QUACKY")
public class DuckyUsers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String userName;

    @Column
    private Boolean userExists;

    @Column
    private Boolean isCheater;

    @OneToMany (mappedBy = "duckyUsers")
    private List<GameBoard> gameBoard;
}
