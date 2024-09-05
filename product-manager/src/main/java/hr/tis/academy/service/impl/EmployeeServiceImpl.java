package hr.tis.academy.service.impl;

import hr.tis.academy.model.Employee;
import hr.tis.academy.repository.EmployeeRepository;
import hr.tis.academy.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
  private final EmployeeRepository employeeRepository;
  @Autowired
  public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
    this.employeeRepository = employeeRepository;
  }

  @Override
  public List<Employee> fetchAllEmployees() {
    return employeeRepository.fetchAllEmployees();
  }

  @Override
  public Employee fetchEmployeeByID(Long id) {
    return employeeRepository.fetchEmployeeByID(id);
  }

  @Override
  public Employee insertEmployee(String oib, Date date_of_birth, String first_name, String last_name, double salary, Date starting_work_date, int vacation_days, Long position_id) {
    return employeeRepository.insertEmployee(oib, date_of_birth, first_name, last_name, salary, starting_work_date, vacation_days, position_id);
  }

  @Override
  public Employee deleteEmployeeById(Long id) {
    return employeeRepository.deleteEmployeeById(id);
  }

  @Override
  public Employee fetchEmployeeByNameOrDate(String first_name, Date starting_work_date) {
    return employeeRepository.fetchEmployeeByNameOrDate(first_name, starting_work_date);
  }
}
