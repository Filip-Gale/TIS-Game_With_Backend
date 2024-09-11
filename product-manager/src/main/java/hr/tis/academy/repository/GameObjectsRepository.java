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
    //    @Query(nativeQuery = true, value = "SELECT e.ID as gameObjectId, e.X, e.Y, e.HEALTH, e.MOVE_DISTANCE, gb.ID as gameBoardId FROM QUACKY.GAME_OBJECTS e JOIN QUACKY.GAME_BOARD gb ON e.GAME_BOARD_ID = gb.ID WHERE gb.DUCKY_USERS_ID = :id")
    @Query(nativeQuery = true, value = "SELECT * FROM QUACKY.GAME_OBJECTS go WHERE go.ENTITY_TYPE = 'MAIN_CHARACTER' AND go.GAME_BOARD_ID IN (SELECT gb.ID FROM QUACKY.GAME_BOARD gb WHERE gb.DUCKY_USERS_ID = :id)")
    GameObjects fetchMainCharacterByUserID(Long id);

    @Query(nativeQuery = true, value = "SELECT * FROM QUACKY.GAME_OBJECTS go WHERE go.ENTITY_TYPE = 'MAIN_CHARACTER' AND go.ID = :mainCharacterID AND go.GAME_BOARD_ID IN (SELECT gb.ID FROM QUACKY.GAME_BOARD gb WHERE gb.DUCKY_USERS_ID = :id)")
    GameObjects fetchMainCharacterSkillsByUserID(Long id, int mainCharacterID);

    @Query(nativeQuery = true, value = "SELECT * FROM QUACKY.GAME_OBJECTS go WHERE go.ENTITY_TYPE = 'ENEMY' AND go.GAME_BOARD_ID IN (SELECT gb.ID FROM QUACKY.GAME_BOARD gb WHERE gb.DUCKY_USERS_ID = :id)")
    List<GameObjects> fetchEnemiesByUserID(Long id);

    @Query(nativeQuery = true, value = "SELECT * FROM QUACKY.GAME_OBJECTS go WHERE go.ENTITY_TYPE = 'EGG' AND go.GAME_BOARD_ID IN (SELECT gb.ID FROM QUACKY.GAME_BOARD gb WHERE gb.DUCKY_USERS_ID = :id)")
    List<GameObjects> fetchEggsByUserID(Long id);

    @Query(nativeQuery = true, value = "SELECT * FROM QUACKY.GAME_OBJECTS go WHERE go.ENTITY_TYPE = 'OBSTACLE' AND go.GAME_BOARD_ID IN (SELECT gb.ID FROM QUACKY.GAME_BOARD gb WHERE gb.DUCKY_USERS_ID = :id)")
    List<GameObjects> fetchObstaclesByUserID(Long id);

    List<GameObjects> findByGameBoardIdAndXAndY(Long gameBoardId, Integer x, Integer y);
}
