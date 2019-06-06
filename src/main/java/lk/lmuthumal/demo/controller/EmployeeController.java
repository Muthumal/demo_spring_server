package lk.lmuthumal.demo.controller;

import lk.lmuthumal.demo.Entity.Company;
import lk.lmuthumal.demo.Entity.Employee;
import lk.lmuthumal.demo.dto.EmployeeDto;
import lk.lmuthumal.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("api/v1/employee")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping
    public @ResponseBody
    List<Employee> getEmployees(){
        return employeeService.findAll();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ResponseEntity insert(@RequestBody EmployeeDto employeeDto){
        Company company = new Company();
        company.setCompanyId(employeeDto.getCompanyId());
        Employee employee = new Employee(employeeDto.getFirstName(),employeeDto.getLastName(),company,employeeDto.getEmail(),employeeDto.getPhoneNo());
        employeeService.insert(employee);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public EmployeeDto getEmployeeById(@PathVariable("id") int id){
        Employee byId = employeeService.getById(id);
        return new EmployeeDto(byId);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping("/{id}")
    public ResponseEntity updateEmployee(@RequestBody EmployeeDto employeeDto, @PathVariable("id") int id){
        Company company = new Company();
        company.setCompanyId(employeeDto.getCompanyId());
        Employee employee = new Employee(employeeDto.getFirstName(),employeeDto.getLastName(),company,employeeDto.getEmail(),employeeDto.getPhoneNo());
        employee.setEmployeeId(id);
        employeeService.update(employee);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public ResponseEntity deleteEmployee(@PathVariable int id){
        employeeService.delete(id);
        return  new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
