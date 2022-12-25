package com.example.employee.controller;

import com.example.employee.model.Employee;
import com.example.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeService.createEmployee(employee);
    }

    @GetMapping("/employees")
    public List<Employee> readEmployees() {
        return employeeService.getEmployees();
    }

    @PutMapping("/employees/{empId}")
    public Employee updateEmployees(@PathVariable(value = "empId") Long id, @RequestBody Employee employeeDetails) {
        return employeeService.updateEmployee(id, employeeDetails);
    }

    @DeleteMapping("/employees/{empId}")
    public void deleteEmployees(@PathVariable(value = "empId") Long id) {
        employeeService.deleteEmployee(id);
    }
}
