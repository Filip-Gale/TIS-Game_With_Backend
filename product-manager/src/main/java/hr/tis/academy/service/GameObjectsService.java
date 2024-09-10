package hr.tis.academy.service;

import hr.tis.academy.model.GameObjects;
import hr.tis.academy.repository.GameObjectsRepository;
import org.springframework.stereotype.Service;

public interface GameObjectsService {

    GameObjects getMainCharacterByUserID(Long userID);
    GameObjects getEnemiesByUserID(Long userID);
    GameObjects getObstaclesByUserID(Long userID);
    GameObjects getEggsByUserID(Long userID);
}
