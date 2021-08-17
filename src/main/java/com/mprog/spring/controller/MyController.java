package com.mprog.spring.controller;

import com.mprog.spring.dao.Dao;
import com.mprog.spring.dao.EmployeeDao;
import com.mprog.spring.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MyController {

    @Autowired
    private Dao<Employee> employeeDao;

    @GetMapping("/")
    public String main(){
        return "index";
    }

    @GetMapping ("/employees")
    public String showAllEmployees(Model model){

        List<Employee> employees = employeeDao.getAll();
        model.addAttribute("employees", employees);

        return "employees";
    }
}
