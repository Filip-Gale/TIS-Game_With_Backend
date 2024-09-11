package hr.tis.academy.service.impl;

import hr.tis.academy.file.LogWriter;
import hr.tis.academy.model.GameObjects;
import hr.tis.academy.repository.GameObjectsRepository;
import hr.tis.academy.service.GameObjectsService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class GameObjectsImpl implements GameObjectsService {

    private final GameObjectsRepository gameObjectsRepository;
    private static final String LOG_FILE = LogWriter.LOG_DIRECTORY + "/game_log.txt";
    private final LogWriter logWriter;

    public GameObjectsImpl(GameObjectsRepository gameObjectsRepository, LogWriter logWriter) {
        this.gameObjectsRepository = gameObjectsRepository;
        this.logWriter = logWriter;
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
}
