package hr.tis.academy.service.impl;

import hr.tis.academy.dto.GameObjectsDTO;
import hr.tis.academy.dto.SkillsDTO;
import hr.tis.academy.file.LogWriter;
import hr.tis.academy.model.GameObjects;
import hr.tis.academy.model.Skills;
import hr.tis.academy.repository.GameObjectsRepository;
import hr.tis.academy.service.GameObjectsService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GameObjectsServiceImpl implements GameObjectsService {
    private final GameObjectsRepository gameObjectsRepository;
    private static final String LOG_FILE = LogWriter.LOG_DIRECTORY + "/game_log.txt";
    private final LogWriter logWriter;
    @Autowired
    public GameObjectsServiceImpl(GameObjectsRepository gameObjectsRepository, LogWriter logWriter) {
        this.gameObjectsRepository = gameObjectsRepository;
        this.logWriter = logWriter;
    }

    @Override
    public GameObjectsDTO getMainCharacterByUserID(Long userID) {
        GameObjects gameObjects = gameObjectsRepository.fetchMainCharacterByUserID(userID);

        GameObjectsDTO gameObjectsDTO = getDefaultGameObjectsDTO(gameObjects);
        gameObjectsDTO.setMoveDistance(gameObjects.getMoveDistance());
        return gameObjectsDTO;
    }

    @Override
    public List<SkillsDTO> getMainCharacterSkillsByUserID(Long userID, int mainCharacterID) {
        List<Skills> skillsList = gameObjectsRepository.fetchMainCharacterSkillsByUserID(userID, mainCharacterID).getSkills();
        List<SkillsDTO> skillsDTOList = new ArrayList<>();
        for (Skills skill : skillsList) {
            SkillsDTO skillsDTO = new SkillsDTO();
            skillsDTO.setId(skill.getId());
            skillsDTO.setDamage(skill.getDamage());
            skillsDTO.setSkillRange(skill.getSkillRange());
            skillsDTO.setSkillDescription(skill.getSkillDescription());
            skillsDTO.setHowMuchItMovesEnemy(skill.getHowMuchItMovesEnemy());
            skillsDTOList.add(skillsDTO);
        }
        return skillsDTOList;
    }

    @Override
    public List<GameObjectsDTO> getEnemiesByUserID(Long userID) {
        List<GameObjects> gameObjectsList = gameObjectsRepository.fetchEnemiesByUserID(userID);
        List<GameObjectsDTO> gameObjectsDTOS = new ArrayList<>();
        gameObjectsList.forEach(gameObject -> {
            GameObjectsDTO gameObjectsDTO = getDefaultGameObjectsDTO(gameObject);
            gameObjectsDTO.setMoveDistance(gameObject.getMoveDistance());
            gameObjectsDTOS.add(gameObjectsDTO);
        });

        return gameObjectsDTOS;
    }

    @Override
    public void logGameObjectPositionDamage(Long id, Integer newX, Integer newY, Integer damage) {
        GameObjects gameObject = gameObjectsRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("GameObject not found with id " + id));

        String entityType = String.valueOf(gameObject.getEntityType());
        String formattedEntityType = entityType.toLowerCase().replace("_", " ");
        formattedEntityType = formattedEntityType.substring(0, 1).toUpperCase() + formattedEntityType.substring(1);


        if (newX != null && newY != null) {
            String moveLog = formattedEntityType + " moves from (" + gameObject.getX() + ", " + gameObject.getY() +
                    ") to (" + newX + ", " + newY + ")";

            logWriter.writeLogToFile(moveLog, LOG_FILE);
            gameObject.setX(newX);
            gameObject.setY(newY);
            gameObjectsRepository.save(gameObject);
        }


        if(damage != null) {
            Integer health = gameObject.getHealth();
            if(health - damage > 0) {
                gameObject.setHealth(health - damage);
                String damageLog = formattedEntityType + " takes " + damage + " damage, his current health is " + (health - damage);
                logWriter.writeLogToFile(damageLog, LOG_FILE);
                gameObjectsRepository.save(gameObject);
            }
            else {
                String defeatLog = formattedEntityType + " is defeated (health <= 0).";
                logWriter.writeLogToFile(defeatLog, LOG_FILE);
                gameObjectsRepository.delete(gameObject);
            }
            gameObject.setHealth(gameObject.getHealth());
        }
    }
    @Override
    public List<GameObjectsDTO> getObstaclesByUserID(Long userID) {
        List<GameObjects> gameObjects = gameObjectsRepository.fetchObstaclesByUserID(userID);

        List<GameObjectsDTO> gameObjectsDTOS = new ArrayList<>();
        gameObjects.forEach(gameObject -> {
            GameObjectsDTO gameObjectsDTO = getDefaultGameObjectsDTO(gameObject);
            gameObjectsDTOS.add(gameObjectsDTO);
        });
        return gameObjectsDTOS;
    }



    @Override
    public List<GameObjectsDTO> getEggsByUserID(Long userID) {
        List<GameObjects> gameObjectsList = gameObjectsRepository.fetchEggsByUserID(userID);
        List<GameObjectsDTO> gameObjectsDTOS = new ArrayList<>();
        gameObjectsList.forEach(gameObject -> {
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
