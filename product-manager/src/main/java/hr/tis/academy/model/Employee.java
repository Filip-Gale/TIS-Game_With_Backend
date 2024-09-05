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
    @ManyToOne
    @JoinColumn(name = "POSITION_ID")
    private Position position;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public Date getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(Date date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public String getOIB() {
        return OIB;
    }

    public void setOIB(String OIB) {
        this.OIB = OIB;
    }

    public Date getStarting_work_date() {
        return starting_work_date;
    }

    public void setStarting_work_date(Date starting_work_date) {
        this.starting_work_date = starting_work_date;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Integer getVacation_days() {
        return vacation_days;
    }

    public void setVacation_days(Integer vacation_days) {
        this.vacation_days = vacation_days;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
