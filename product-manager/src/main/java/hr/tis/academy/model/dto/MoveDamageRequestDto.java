package hr.tis.academy.model.dto;

public class MoveDamageRequestDto {
    private Integer objectNewX;
    private Integer objectNewY;
    private Integer damage;

    public Integer getObjectNewX() {
        return objectNewX;
    }

    public void setObjectNewX(Integer objectNewX) {
        this.objectNewX = objectNewX;
    }

    public Integer getObjectNewY() {
        return objectNewY;
    }

    public void setObjectNewY(Integer objectNewY) {
        this.objectNewY = objectNewY;
    }

    public Integer getDamage() {
        return damage;
    }

    public void setDamage(Integer damage) {
        this.damage = damage;
    }
}
