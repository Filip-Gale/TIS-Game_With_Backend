package hr.tis.academy.dto;

import hr.tis.academy.model.Position;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.util.Date;

public class EmployeeDto {
    private String first_name;
    private String last_name;
    private Date starting_work_date;
    private Double salary;
    private Integer vacation_days;
    private Position position;

    public EmployeeDto(String first_name, String last_name, Date starting_work_date, Double salary, Integer vacation_days, Position position) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.starting_work_date = starting_work_date;
        this.salary = salary;
        this.vacation_days = vacation_days;
        this.position = position;
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
