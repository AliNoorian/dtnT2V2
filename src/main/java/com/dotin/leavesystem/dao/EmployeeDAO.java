package com.dotin.leavesystem.dao;

import com.dotin.leavesystem.models.Employee;

import java.util.List;

public interface EmployeeDAO {

     List<Employee> findAll();
     Employee findById(int Id);
     void save(Employee employee);
     void deleteById(int id);

}
