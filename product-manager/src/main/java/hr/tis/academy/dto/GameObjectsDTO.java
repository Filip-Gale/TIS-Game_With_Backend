package hr.tis.academy.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import hr.tis.academy.enums.EntityType;
import hr.tis.academy.model.Skills;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class GameObjectsDTO {

    public GameObjectsDTO() {

    }

    private Long id;
    private Integer x;
    private Integer y;
    private Integer moveDistance;
    private Integer health;
    private EntityType entityType;
    private List<Skills> skillsList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public Integer getMoveDistance() {
        return moveDistance;
    }

    public void setMoveDistance(Integer moveDistance) {
        this.moveDistance = moveDistance;
    }

    public Integer getHealth() {
        return health;
    }

    public void setHealth(Integer health) {
        this.health = health;
    }

    public EntityType getEntityType() {
        return entityType;
    }

    public void setEntityType(EntityType entityType) {
        this.entityType = entityType;
    }

    public List<Skills> getSkillsList() {
        return skillsList;
    }

    public void setSkillsList(List<Skills> skillsList) {
        this.skillsList = skillsList;
    }
}
