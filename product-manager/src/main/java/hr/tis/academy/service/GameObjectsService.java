package hr.tis.academy.service;

import hr.tis.academy.dto.GameObjectsDTO;
import hr.tis.academy.dto.SkillsDTO;
import hr.tis.academy.model.GameObjects;
import hr.tis.academy.model.Skills;

import java.util.List;

public interface GameObjectsService {

    GameObjectsDTO getMainCharacterByUserID(Long userID);
    List<SkillsDTO> getMainCharacterSkillsByUserID(Long userID, int mainCharacterID);
    List<GameObjectsDTO> getEnemiesByUserID(Long userID);
    List<GameObjectsDTO> getObstaclesByUserID(Long userID);
    List<GameObjectsDTO> getEggsByUserID(Long userID);
    void logGameObjectPositionDamage(Long id, Integer newX, Integer newY, Integer damage);
}
