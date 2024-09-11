package hr.tis.academy.controller;

import hr.tis.academy.dto.GameObjectsDTO;
import hr.tis.academy.dto.SkillsDTO;
import hr.tis.academy.model.GameObjects;
import hr.tis.academy.model.Skills;
import hr.tis.academy.service.GameObjectsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/game-objects")
public class GameObjectsController {
    private final GameObjectsService gameObjectsService;

    @Autowired
    public GameObjectsController(GameObjectsService gameObjectsService) {
        this.gameObjectsService = gameObjectsService;
    }

    @GetMapping("/main-character")
    GameObjectsDTO getMainCharacterByUserID(@RequestParam("userId") int userID) {
        return gameObjectsService.getMainCharacterByUserID((long) userID);
    }

    @GetMapping("/main-character/{mainCharacterID}/skills")
    List<SkillsDTO> getMainCharacterSkillsByUserID(@RequestParam("userId") int userID, @PathVariable int mainCharacterID) {
        return gameObjectsService.getMainCharacterSkillsByUserID((long) userID, mainCharacterID);
    }

    @GetMapping("/enemies")
    List<GameObjectsDTO> getEnemiesByUserID(@RequestParam("userId") int userID) {
        return gameObjectsService.getEnemiesByUserID((long) userID);
    }

    @GetMapping("/obstacles")
    List<GameObjectsDTO> getObstaclesByUserID(@RequestParam("userId") int userID) {
         return gameObjectsService.getObstaclesByUserID((long) userID);
    }

    @GetMapping("/eggs")
    List<GameObjectsDTO> getEggsByUserID(@RequestParam("userId") int userID) {
        return gameObjectsService.getEggsByUserID((long) userID);
    }


}
