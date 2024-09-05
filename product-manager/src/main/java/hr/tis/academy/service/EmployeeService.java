package hr.tis.academy.service;

import hr.tis.academy.model.Employee;

import java.util.Date;
import java.util.List;

public interface EmployeeService {
  List<Employee> fetchAllEmployees();
  Employee fetchEmployeeByID(Long id);
  Employee insertEmployee(String oib, Date date_of_birth, String first_name, String last_name, double salary, Date starting_work_date, int vacation_days, Long position_id);
  Employee deleteEmployeeById(Long id);
  Employee fetchEmployeeByNameOrDate(String first_name, Date starting_work_date);
}
