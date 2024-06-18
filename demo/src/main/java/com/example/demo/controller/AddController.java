package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;

@Controller
public class AddController {

    private final EmployeeRepository employeeRepository;

    public AddController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @PostMapping("/add_employee")
    public RedirectView addEmployee(Employee employee, Model model) {

        if (employeeRepository.existsByUsername(employee.getUsername())) {
            model.addAttribute("error", true); 
            return new RedirectView("/add_employee"); 
        }
        
        employeeRepository.save(employee);
        model.addAttribute("success", true); 
        return new RedirectView("/admin");
    }
}
