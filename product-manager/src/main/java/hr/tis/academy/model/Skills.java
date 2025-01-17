package hr.tis.academy.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "SKILLS", schema = "QUACKY")
public class Skills {
    public Skills() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Integer damage;

    @Column
    private Integer skillRange;

    @Column
    private Boolean movesEnemy;

    @Column
    private Integer howMuchItMovesEnemy;

    @Column
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

    public Boolean getMovesEnemy() {
        return movesEnemy;
    }

    public void setMovesEnemy(Boolean movesEnemy) {
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
