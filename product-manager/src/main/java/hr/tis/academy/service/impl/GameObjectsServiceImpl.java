package hr.tis.academy.service.impl;

import hr.tis.academy.model.GameObjects;
import hr.tis.academy.model.Skills;
import hr.tis.academy.repository.GameObjectsRepository;
import hr.tis.academy.service.GameObjectsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameObjectsServiceImpl implements GameObjectsService {
    private final GameObjectsRepository gameObjectsRepository;

    @Autowired
    public GameObjectsServiceImpl(GameObjectsRepository gameObjectsRepository) {
        this.gameObjectsRepository = gameObjectsRepository;
    }

    @Override
    public GameObjects getMainCharacterByUserID(Long userID) {
        return gameObjectsRepository.fetchMainCharacterByUserID(userID);
    }

    @Override
    public GameObjects getMainCharacterSkillsByUserID(Long userID) {
        return gameObjectsRepository.fetchMainCharacterSkillsByUserID(userID);
    }

    @Override
    public List<GameObjects> getEnemiesByUserID(Long userID) {
        return gameObjectsRepository.fetchEnemiesByUserID(userID);
    }

    @Override
    public List<GameObjects> getObstaclesByUserID(Long userID) {
        return gameObjectsRepository.fetchObstaclesByUserID(userID);
    }

    @Override
    public List<GameObjects> getEggsByUserID(Long userID) {

        return gameObjectsRepository.fetchEggsByUserID(userID);
    }
}
