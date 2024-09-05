package hr.tis.academy.model;

import hr.tis.academy.enums.Level;
import hr.tis.academy.enums.Title;
import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name="POSITION", schema = "PRODUCT_MANAGER")
public class Position implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private Title title;
    @Enumerated(EnumType.STRING)
    private Level level;
}
