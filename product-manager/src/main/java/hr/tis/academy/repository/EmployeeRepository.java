package hr.tis.academy.repository;

import hr.tis.academy.dto.EmployeeDto;
import hr.tis.academy.model.Employee;
import hr.tis.academy.model.ProductsMetadata;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
  @Query(nativeQuery = true, value = "SELECT * FROM PRODUCT_MANAGER.EMPLOYEE")
  List<Employee> fetchAllEmployees();

  @Query(nativeQuery = true, value = "SELECT * FROM PRODUCT_MANAGER.EMPLOYEE e WHERE e.ID = :id")
  Employee fetchEmployeeByID(Long id);

  @Modifying
  @Transactional
  @Query(nativeQuery = true, value = "INSERT INTO PRODUCT_MANAGER.EMPLOYEE (OIB, DATE_OF_BIRTH, FIRST_NAME, LAST_NAME, SALARY, STARTING_WORK_DATE, VACATION_DAYS, POSITION_ID) VALUES(:oib, :date_of_birth, :first_name, :last_name, :salary, :starting_work_date, :vacation_days, :position_id)")
  Integer insertEmployee(String oib, Date date_of_birth, String first_name, String last_name, double salary, Date starting_work_date, int vacation_days, Long position_id);

  @Modifying
  @Transactional
  @Query(nativeQuery = true, value = "DELETE FROM PRODUCT_MANAGER.EMPLOYEE e WHERE e.ID = :id")
  Integer deleteEmployeeById(Long id);

  @Query(nativeQuery = true, value = "SELECT * FROM PRODUCT_MANAGER.EMPLOYEE e WHERE (:first_name is null OR e.FIRST_NAME = :first_name) AND (:starting_work_date is null OR e.STARTING_WORK_DATE = :starting_work_date)")
  Employee fetchEmployeeByNameOrDate(String first_name, Date starting_work_date);
}
