package hr.tis.academy.controller;

import hr.tis.academy.dto.GameObjectsDTO;
import hr.tis.academy.model.GameObjects;
import hr.tis.academy.service.GameObjectsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/game-objects/")
public class GameObjectsController {
    private final GameObjectsService gameObjectsService;

    @Autowired
    public GameObjectsController(GameObjectsService gameObjectsService) {
        this.gameObjectsService = gameObjectsService;
    }

    @GetMapping("main-character{userID}")
    GameObjectsDTO getMainCharacterByUserID(@PathVariable int userID) {
        GameObjects gameObjects = gameObjectsService.getMainCharacterByUserID((long) userID);
        GameObjectsDTO gameObjectsDTO = new GameObjectsDTO();
        gameObjectsDTO.setId(gameObjects.getId());
        gameObjectsDTO.setX(gameObjects.getX());
        gameObjectsDTO.setY(gameObjects.getY());
        gameObjectsDTO.setHealth(gameObjects.getHealth());
        gameObjectsDTO.setMoveDistance(gameObjects.getMoveDistance());

        return gameObjectsDTO;
    }
}
