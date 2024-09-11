package hr.tis.academy.model.dto;

import hr.tis.academy.enums.GameState;

public class GameStateDto {
    public Long userId;
    public GameState gameState;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
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
