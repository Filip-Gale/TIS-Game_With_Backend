package hr.tis.academy.controller;

import hr.tis.academy.dto.GameObjectsDTO;
import hr.tis.academy.dto.SkillsDTO;
import hr.tis.academy.model.GameObjects;
import hr.tis.academy.model.Skills;
import hr.tis.academy.service.GameObjectsService;
import org.hibernate.internal.util.collections.ArrayHelper;
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
        GameObjects gameObjects = gameObjectsService.getMainCharacterByUserID((long) userID);
        GameObjectsDTO gameObjectsDTO = getDefaultGameObjectsDTO(gameObjects);
        gameObjectsDTO.setMoveDistance(gameObjects.getMoveDistance());

        return gameObjectsDTO;
    }

    @GetMapping("/main-character/{skillNumber}/skills")
    SkillsDTO getMainCharacterSkillsByUserID(@RequestParam("userId") int userID, @PathVariable int skillNumber) {
        GameObjects gameObjects = gameObjectsService.getMainCharacterByUserID((long) userID);
        List<Skills> skillsList = gameObjects.getSkills();
        Skills skill = skillsList.get(skillNumber);
        SkillsDTO skillsDTO = new SkillsDTO();
        skillsDTO.setId(skill.getId());
        skillsDTO.setDamage(skill.getDamage());
        skillsDTO.setSkillRange(skill.getSkillRange());
        skillsDTO.setSkillDescription(skill.getSkillDescription());
        skillsDTO.setHowMuchItMovesEnemy(skill.getHowMuchItMovesEnemy());
        return skillsDTO;
    }

    @GetMapping("/enemies")
    List<GameObjectsDTO> getEnemiesByUserID(@RequestParam("userId") int userID) {
        List<GameObjects> gameObjects = gameObjectsService.getEnemiesByUserID((long) userID);
        List<GameObjectsDTO> gameObjectsDTOS = new ArrayList<>();
        gameObjects.forEach(gameObject -> {
            GameObjectsDTO gameObjectsDTO = getDefaultGameObjectsDTO(gameObject);
            gameObjectsDTO.setMoveDistance(gameObject.getMoveDistance());
            gameObjectsDTOS.add(gameObjectsDTO);
        });

        return gameObjectsDTOS;
    }
    @GetMapping("/obstacles")
    List<GameObjectsDTO> getObstaclesByUserID(@RequestParam("userId") int userID) {
        List<GameObjects> gameObjects = gameObjectsService.getObstaclesByUserID((long) userID);
        List<GameObjectsDTO> gameObjectsDTOS = new ArrayList<>();
        gameObjects.forEach(gameObject -> {
            GameObjectsDTO gameObjectsDTO = getDefaultGameObjectsDTO(gameObject);
            gameObjectsDTOS.add(gameObjectsDTO);
        });

        return gameObjectsDTOS;
    }

    @GetMapping("/eggs")
    List<GameObjectsDTO> getEggsByUserID(@RequestParam("userId") int userID) {
        List<GameObjects> gameObjects = gameObjectsService.getEggsByUserID((long) userID);
        List<GameObjectsDTO> gameObjectsDTOS = new ArrayList<>();
        gameObjects.forEach(gameObject -> {
            GameObjectsDTO gameObjectsDTO = getDefaultGameObjectsDTO(gameObject);
            gameObjectsDTOS.add(gameObjectsDTO);
        });

        return gameObjectsDTOS;
    }


    private static GameObjectsDTO getDefaultGameObjectsDTO(GameObjects gameObjects) {
        GameObjectsDTO gameObjectsDTO = new GameObjectsDTO();
        gameObjectsDTO.setId(gameObjects.getId());
        gameObjectsDTO.setX(gameObjects.getX());
        gameObjectsDTO.setY(gameObjects.getY());
        gameObjectsDTO.setHealth(gameObjects.getHealth());
        return gameObjectsDTO;
    }
}
