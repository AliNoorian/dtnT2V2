package com.dotin.leavesystem.service;

import com.dotin.leavesystem.dao.EmployeeServie;
import com.dotin.leavesystem.models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeServie employeeDAO;

    @Autowired
    public EmployeeServiceImpl(EmployeeServie employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    @Transactional
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }

    @Override
    @Transactional
    public Employee findById(int Id) {
        return employeeDAO.findById(Id);
    }

    @Override
    @Transactional
    public void save(Employee employee) {
        employeeDAO.save(employee);
    }

    @Override
    @Transactional
    public void deleteById(int Id) {
        employeeDAO.deleteById(Id);
    }
}
