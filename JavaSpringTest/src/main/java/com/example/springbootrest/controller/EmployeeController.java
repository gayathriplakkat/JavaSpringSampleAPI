package com.example.springbootrest.controller;

import com.example.springbootrest.exception.ResourceNotFoundException;
import com.example.springbootrest.model.Employee;
import com.example.springbootrest.repository.EmployeeRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/employee")
@Api(value = "HelloWorld Resource", description = "Employee Data")
public class EmployeeController {
    
    @Autowired
    EmployeeRepository employeeRepository;

    @ApiOperation(value = "Get list of all employees")
    @GetMapping("/list")
    public List<Employee> getEmployeeList(){
        return employeeRepository.findAll();
    }

    @ApiOperation(value = "Get employee by id")
    @GetMapping("/list/{id}")
    public ResponseEntity<Employee>getEmployeeById(@PathVariable(value = "id") long id) throws ResourceNotFoundException {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Employee not foundfor this id : " + id));
        return ResponseEntity.ok().body(employee);
    }

    @ApiOperation(value = "Add new Employee entry")
    @PostMapping("/add")
    public Employee addEmployee(@Valid @RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }

    @ApiOperation(value = "Update Employee details")
    @PutMapping("update/{id}")
    public ResponseEntity<Employee>updateEmployeeById(@PathVariable(value = "id") long id,
                                                    @Valid @RequestBody Employee employeeDetails) throws ResourceNotFoundException {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Employee not foundfor this id : " + id));
        employee.setName(employeeDetails.getName());
        employee.setDateOfBirth(employeeDetails.getDateOfBirth());


        Employee updatedEmployee = employeeRepository.save(employee);
        return ResponseEntity.ok().body(updatedEmployee);
    }

    @ApiOperation(value = "Delete an entry")
    @DeleteMapping("delete/{id}")
    public Map<String,Boolean> deleteEmployee(@PathVariable(value = "id") long id) throws ResourceNotFoundException {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Employee not foundfor this id : " + id));
        employeeRepository.deleteById(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
        
    }
}
