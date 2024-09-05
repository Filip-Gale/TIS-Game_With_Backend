package hr.tis.academy.controller;

import hr.tis.academy.model.Employee;
import hr.tis.academy.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
  private final EmployeeService employeeService;
  @Autowired
  public EmployeeController(EmployeeService employeeService) {
    this.employeeService = employeeService;
  }

  @GetMapping("/fetch")
  public List<Employee> fetchAllEmployees() {
    return employeeService.fetchAllEmployees();
  }

  @GetMapping("/fetch/{id}")
  public Employee fetchEmployeeByID(@PathVariable Long id) {
    return employeeService.fetchEmployeeByID(id);
  }

  @PostMapping
  public Employee insertEmployee(@RequestBody Employee employee) {
    return employeeService.insertEmployee(employee.getOIB(), employee.getDate_of_birth(), employee.getFirst_name(), employee.getLast_name(), employee.getSalary(), employee.getStarting_work_date(), employee.getVacation_days(), employee.getPosition().getId());
  }

  @DeleteMapping("/{id}")
  public Employee deleteEmployeeById(@PathVariable Long id) {
    return employeeService.deleteEmployeeById(id);
  }

  @GetMapping("/fetchByNameOrDate")
  public Employee fetchEmployeeByNameOrDate(@RequestParam String first_name, @RequestParam Date starting_work_date) {
    return employeeService.fetchEmployeeByNameOrDate(first_name, starting_work_date);
  }
}
