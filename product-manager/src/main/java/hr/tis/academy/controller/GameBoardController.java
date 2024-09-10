package hr.tis.academy.controller;

import hr.tis.academy.dto.GameObjectsDTO;
import hr.tis.academy.model.GameGrid;
import hr.tis.academy.model.dto.GameGridDto;
import hr.tis.academy.service.GameBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/game-board")
public class GameBoardController {

    private final GameBoardService gameBoardService;

    @Autowired
    public GameBoardController(GameBoardService gameBoardService) {
        this.gameBoardService = gameBoardService;
    }

    @GetMapping
    GameGridDto getGameGrid(@RequestParam Long userId){
        return gameBoardService.findGameGridByUserId(userId);
    }

    @GetMapping("details")
    GameObjectsDTO getGridDetails(@RequestParam Integer x, @RequestParam Integer y, @RequestParam Long userId){
        return  gameBoardService.getBoardTileDetail(x, y, userId);
    }
}
