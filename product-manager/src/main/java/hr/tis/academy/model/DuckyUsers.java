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
    private Boolean isCheater;

    @OneToMany (mappedBy = "duckyUsers")
    private List<GameBoard> gameBoard;

    public DuckyUsers() {}

    public DuckyUsers(String userName, Boolean userExists, Boolean isCheater) {
        this.userName = userName;
        this.isCheater = isCheater;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Boolean getCheater() {
        return isCheater;
    }

    public void setCheater(Boolean cheater) {
        isCheater = cheater;
    }

    public List<GameBoard> getGameBoard() {
        return gameBoard;
    }

    public void setGameBoard(List<GameBoard> gameBoard) {
        this.gameBoard = gameBoard;
    }
}
