package hr.tis.academy.repository;

import hr.tis.academy.model.GameObjects;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface GameObjectsRepository extends JpaRepository<GameObjects, Long>{
    @Query(nativeQuery = true, value = "SELECT * FROM QUACKY. e WHERE e.ENTITY_TYPE = 'MAIN_CHARACTER' AND e.GAME_BOARD_ID.DUCKY_USERS_ID = :id")
    GameObjects fetchMainCharacterByUserID(Long id);

    @Query(nativeQuery = true, value = "SELECT * FROM QUACKY. e WHERE e.ID = :id")
    GameObjects fetchEnemyByUserID(Long id);

    @Query(nativeQuery = true, value = "SELECT * FROM QUACKY. e WHERE e.ID = :id")
    GameObjects fetchEggByUserID(Long id);

    @Query(nativeQuery = true, value = "SELECT * FROM QUACKY. e WHERE e.ID = :id")
    GameObjects fetchObstacleByUserID(Long id);
}
