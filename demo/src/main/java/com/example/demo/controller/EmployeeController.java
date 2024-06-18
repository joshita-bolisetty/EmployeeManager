package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;

@Controller
public class EmployeeController {

     @Autowired
    private EmployeeRepository employeeRepository;

     @GetMapping("/employee")
     public String employeeDashboard(@RequestParam("username") String username, Model model) {
        
        model.addAttribute("username", username);
        Employee employee = employeeRepository.findByUsername(username);
        model.addAttribute("name", employee.getName());
        return "employee"; 
      }

   @PostMapping("/emplogout")
    public RedirectView logout() {        
        return new RedirectView("/login");
    }
}
