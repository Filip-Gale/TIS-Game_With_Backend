package hr.tis.academy.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "SKILLS", schema = "QUACKY")
public class Skills {
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

}
