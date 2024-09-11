package hr.tis.academy.service;

import hr.tis.academy.model.GameObjects;
import hr.tis.academy.model.Skills;
import hr.tis.academy.repository.GameObjectsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

public interface GameObjectsService {

    GameObjects getMainCharacterByUserID(Long userID);
    GameObjects getMainCharacterSkillsByUserID(Long userID);
    List<GameObjects> getEnemiesByUserID(Long userID);
    List<GameObjects> getObstaclesByUserID(Long userID);
    List<GameObjects> getEggsByUserID(Long userID);
}
