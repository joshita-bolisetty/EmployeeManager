package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;

@Controller
public class EditController {
    
    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/edit/{id}") // Change the endpoint to /edit/{id}
    public String getEmployeeById(@PathVariable Long id, Model model) {
        // Retrieve the employee details by ID
        Employee employee = employeeRepository.findById(id).orElse(null);
        
        // Add the employee details to the model
        model.addAttribute("employee", employee);
        
        // Return the edit page template
        return "edit";
    }

    @PostMapping("/update_employee")
    public String updateEmployee(
        @RequestParam Long id,
        @RequestParam String username,
        @RequestParam String name,  
        @RequestParam String post,  
        Model model
    ) {
        Employee employee = employeeRepository.findById(id).orElse(null);
        if (employee != null) {
            employee.setUsername(username);
            employee.setName(name);            
            employee.setPost(post);
            employeeRepository.save(employee);
        }
        return "redirect:/admin";
    }

}
