package hr.tis.academy.controller;

import hr.tis.academy.dto.EmployeeDto;
import hr.tis.academy.model.Employee;
import hr.tis.academy.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
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
  public List<EmployeeDto> fetchAllEmployees() {
    List<Employee> employeeList = employeeService.fetchAllEmployees();
    List<EmployeeDto> employeeDtoList = new ArrayList<>();
    for (Employee employee : employeeList) {
      EmployeeDto employeeDto = new EmployeeDto(employee.getFirst_name(), employee.getLast_name(), employee.getStarting_work_date(), employee.getSalary(), employee.getVacation_days(), employee.getPosition());
      employeeDtoList.add(employeeDto);
    }
    return employeeDtoList;
  }

  @GetMapping("/fetch/{id}")
  public EmployeeDto fetchEmployeeByID(@PathVariable Long id) {
    Employee employee = employeeService.fetchEmployeeByID(id);
    EmployeeDto employeeDto = new EmployeeDto(employee.getFirst_name(), employee.getLast_name(), employee.getStarting_work_date(), employee.getSalary(), employee.getVacation_days(), employee.getPosition());
    return employeeDto;
  }

  @PostMapping
  public Integer insertEmployee(@RequestBody Employee employee) {
    return employeeService.insertEmployee(employee.getOIB(), employee.getDate_of_birth(), employee.getFirst_name(), employee.getLast_name(), employee.getSalary(), employee.getStarting_work_date(), employee.getVacation_days(), employee.getPosition().getId());
  }

  @DeleteMapping("/{id}")
  public Integer deleteEmployeeById(@PathVariable Long id) {
    return employeeService.deleteEmployeeById(id);
  }

  @GetMapping("/fetchByNameOrDate")
  public EmployeeDto fetchEmployeeByNameOrDate(@RequestParam String first_name, @RequestParam String starting_work_date){
    java.sql.Date working_date = null;
    if(starting_work_date != null && !starting_work_date.isEmpty())
    {
      try{
        working_date = java.sql.Date.valueOf(starting_work_date);
      }catch (Exception e)
      {
        throw new RuntimeException(e);
      }
    }
    if(first_name.isEmpty())
    {
      first_name = null;
    }
    Employee employee = employeeService.fetchEmployeeByNameOrDate(first_name, working_date);
    EmployeeDto employeeDto = new EmployeeDto(employee.getFirst_name(), employee.getLast_name(), employee.getStarting_work_date(), employee.getSalary(), employee.getVacation_days(), employee.getPosition());
    return employeeDto;
  }
}
