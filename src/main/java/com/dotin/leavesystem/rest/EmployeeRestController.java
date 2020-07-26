package com.dotin.leavesystem.rest;

import com.dotin.leavesystem.dao.EmployeeDAO;
import com.dotin.leavesystem.models.Employee;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private final EmployeeDAO employeeServie;

    public EmployeeRestController(EmployeeDAO employeeServie) {
        this.employeeServie = employeeServie;
    }

    @GetMapping("/employee")
    public List<Employee> findAll() {
        return employeeServie.findAll();
    }

    @GetMapping("/employee/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId) {

        Employee theEmployee = employeeServie.findById(employeeId);
        if (theEmployee == null) {
            throw new RuntimeException("Employee id not found - " + employeeId);
        }
        return theEmployee;
    }

    @PostMapping("/employee")
    public Employee addEmployee(@RequestBody Employee theEmployee) {

        theEmployee.setEmployeeId(0);
        employeeServie.save(theEmployee);
        return theEmployee;

    }

    @PutMapping("/employee")
    public Employee updateEmployee(@RequestBody Employee theEmployee) {

        employeeServie.save(theEmployee);
        return theEmployee;

    }

    @DeleteMapping("/employee/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId) {

        Employee theEmployee = employeeServie.findById(employeeId);
        if (theEmployee == null) {
            throw new RuntimeException("Employee id not found - " + employeeId);
        }
        employeeServie.deleteById(employeeId);
        return "Successfully deleted employee id - " + employeeId;
    }

}
