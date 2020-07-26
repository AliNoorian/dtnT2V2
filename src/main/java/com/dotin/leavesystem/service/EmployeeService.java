package com.dotin.leavesystem.service;

import com.dotin.leavesystem.models.Employee;

import java.util.List;

public interface EmployeeService {

     List<Employee> findAll();

     Employee findById(int Id);

     void save(Employee employee);

     void deleteById(int Id);
}
