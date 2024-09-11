package hr.tis.academy.controller;

import hr.tis.academy.model.dto.GameStateDto;
import hr.tis.academy.service.GameBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/game/")
public class GameStateController {

    private final GameBoardService gameBoardService;

    @Autowired
    public GameStateController(GameBoardService gameBoardService) {
        this.gameBoardService = gameBoardService;
    }

    @PatchMapping("game-over")
    public void updateGameState(@RequestBody GameStateDto gameStateDto) {
        gameBoardService.updateGameState(gameStateDto);
    }
}
