package com.mprog.spring.controller;

import com.mprog.spring.dao.Dao;
import com.mprog.spring.dao.EmployeeDao;
import com.mprog.spring.entity.Employee;
import com.mprog.spring.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MyController {

    @Autowired
    private Service<Employee> employeeService;

    @GetMapping("/")
    public String main() {
        return "index";
    }

    @GetMapping("/employees")
    public String showAllEmployees(Model model) {

        List<Employee> employees = employeeService.getAll();
        model.addAttribute("employees", employees);

        return "employees";
    }

    @GetMapping("/add")
    public String addEmployee(Model model){
        Employee employee = new Employee();
        model.addAttribute("employee", employee);

        return "addEmployee";
    }

    @PostMapping("/add")
    public String putEmployee(@ModelAttribute("employee") Employee employee){
        employeeService.save(employee);

        return "redirect:employees";
    }

    @GetMapping("/update/{id}")
    public String updateEmployee(Model model, @PathVariable("id") int id){

        model.addAttribute("employee", employeeService.findByID(id));

        return "addEmployee";
    }
}
