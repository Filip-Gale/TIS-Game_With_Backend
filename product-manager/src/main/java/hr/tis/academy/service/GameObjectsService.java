package hr.tis.academy.service;

import hr.tis.academy.model.GameObjects;
import hr.tis.academy.repository.GameObjectsRepository;
import org.springframework.stereotype.Service;

@Service
public interface GameObjectsService {

    GameObjects getMainCharacterByUserID(Integer userID);
    GameObjects getEnemiesByUserID(Integer userID);
    GameObjects getObstaclesByUserID(Integer userID);
    GameObjects getEggsByUserID(Integer userID);
}
