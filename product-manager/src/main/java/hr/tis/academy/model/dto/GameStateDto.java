package hr.tis.academy.model.dto;

import hr.tis.academy.enums.GameState;

public class GameStateDto {
    public Integer userId;
    public GameState gameState;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public GameStateDto() {
    }
}
