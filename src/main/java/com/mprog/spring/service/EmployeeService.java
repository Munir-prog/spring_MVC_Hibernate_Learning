package com.mprog.spring.service;

import com.mprog.spring.dao.Dao;
import com.mprog.spring.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@org.springframework.stereotype.Service

public class EmployeeService implements Service<Employee> {

    @Autowired
    private Dao<Employee> employeeDao;

    @Override
    @Transactional
    public List<Employee> getAll() {
        return employeeDao.getAll();
    }

    @Override
    @Transactional
    public void save(Employee e) {
        employeeDao.save(e);
    }

    @Override
    @Transactional
    public Employee findByID(int id) {
        return employeeDao.findByID(id);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        employeeDao.deleteById(id);
    }
}
