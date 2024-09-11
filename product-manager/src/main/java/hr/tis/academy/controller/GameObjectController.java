package hr.tis.academy.controller;


import hr.tis.academy.model.dto.MoveDamageRequestDto;
import hr.tis.academy.service.GameObjectsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/game-objects/")
public class GameObjectController {

    private final GameObjectsService gameObjectsService;

    @Autowired
    public GameObjectController(GameObjectsService gameObjectsService) {
        this.gameObjectsService = gameObjectsService;
    }

    @PostMapping("{id}/move")
    public void moveGameObject(@PathVariable Long id, @RequestBody MoveDamageRequestDto moveDamageRequestDto) {
        gameObjectsService.logGameObjectPositionDamage(id, moveDamageRequestDto.getObjectNewX(), moveDamageRequestDto.getObjectNewY(), moveDamageRequestDto.getDamage());
    }

    @PostMapping("{id}/take-damage")
    public void takeDamageGameObject(@PathVariable Long id, @RequestBody MoveDamageRequestDto moveDamageRequestDto) {
        gameObjectsService.logGameObjectPositionDamage(id, moveDamageRequestDto.getObjectNewX(),
                moveDamageRequestDto.getObjectNewY(), moveDamageRequestDto.getDamage());
    }
}
