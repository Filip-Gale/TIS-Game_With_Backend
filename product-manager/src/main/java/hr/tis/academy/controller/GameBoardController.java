package hr.tis.academy.controller;

import hr.tis.academy.model.dto.GameHistoryDto;
import hr.tis.academy.service.GameBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/game-board/")
public class GameBoardController {

    private final GameBoardService gameBoardService;

    @Autowired
    public GameBoardController(GameBoardService gameBoardService) {
        this.gameBoardService = gameBoardService;
    }

    @GetMapping("/history")
    public List<GameHistoryDto> getHistory(@RequestParam("start") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime start,
                                           @RequestParam("end") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime end) {
        return gameBoardService.getGameBoardsForInterval(start, end);
    }

}
