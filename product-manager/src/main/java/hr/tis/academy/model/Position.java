package hr.tis.academy.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name="POSITION", schema = "PRODUCT_MANAGER")
public class Position implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private String title;
}
