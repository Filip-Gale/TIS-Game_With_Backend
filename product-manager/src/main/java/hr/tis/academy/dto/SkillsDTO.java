package hr.tis.academy.dto;

public class SkillsDTO {
    public SkillsDTO() {
    }

    private Long id;
    private Integer damage;
    private Integer skillRange;
    private Integer movesEnemy;
    private Integer howMuchItMovesEnemy;
    private String skillDescription;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getDamage() {
        return damage;
    }

    public void setDamage(Integer damage) {
        this.damage = damage;
    }

    public Integer getSkillRange() {
        return skillRange;
    }

    public void setSkillRange(Integer skillRange) {
        this.skillRange = skillRange;
    }

    public Integer getMovesEnemy() {
        return movesEnemy;
    }

    public void setMovesEnemy(Integer movesEnemy) {
        this.movesEnemy = movesEnemy;
    }

    public Integer getHowMuchItMovesEnemy() {
        return howMuchItMovesEnemy;
    }

    public void setHowMuchItMovesEnemy(Integer howMuchItMovesEnemy) {
        this.howMuchItMovesEnemy = howMuchItMovesEnemy;
    }

    public String getSkillDescription() {
        return skillDescription;
    }

    public void setSkillDescription(String skillDescription) {
        this.skillDescription = skillDescription;
    }
}
