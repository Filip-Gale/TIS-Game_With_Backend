package hr.tis.academy.service.impl;

import hr.tis.academy.model.GameObjects;
import hr.tis.academy.repository.GameObjectsRepository;
import hr.tis.academy.service.GameObjectsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameObjectsServiceImpl implements GameObjectsService {
    private final GameObjectsRepository gameObjectsRepository;

    @Autowired
    public GameObjectsServiceImpl(GameObjectsRepository gameObjectsRepository) {
        this.gameObjectsRepository = gameObjectsRepository;
    }

    @Override
    public GameObjects getMainCharacterByUserID(Integer userID) {
        return null;
    }

    @Override
    public GameObjects getEnemiesByUserID(Integer userID) {
        return null;
    }

    @Override
    public GameObjects getObstaclesByUserID(Integer userID) {
        return null;
    }

    @Override
    public GameObjects getEggsByUserID(Integer userID) {
        return null;
    }
}
