package hr.tis.academy.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "EMPLOYEE", schema = "PRODUCT_MANAGER")
public class Employee implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String first_name;
    @Column(nullable = false)
    private String last_name;
    @Column(nullable = false)
    private Date date_of_birth;
    @Column(length = 11, nullable = false, unique = true)
    private String OIB;
    @Column
    private Date starting_work_date;
    @Column
    private Double salary;
    @Column
    private Integer vacation_days;
}
