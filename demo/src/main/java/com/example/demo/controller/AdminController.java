package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;
import com.example.demo.repository.EmployeeRepository;

@Controller
public class AdminController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/admin")
    public String getEmployeeList(Model model) {
        model.addAttribute("employees", employeeRepository.findAll());
        return "admin"; 
    }

    @PostMapping("/add")
    public RedirectView add() {        
        return new RedirectView("/add");
    }

    @PostMapping("/adminlogout")
    public RedirectView logout() {        
        return new RedirectView("/login");
    }

    @GetMapping("/update")
    public String edit(@RequestParam Long id, Model model) {
        model.addAttribute("employee", employeeRepository.findById(id).orElse(null));
        return "edit";
    }

    @PostMapping("/delete")
    public RedirectView deleteEmployee(@RequestParam Long id) {
        employeeRepository.deleteById(id);
        return new RedirectView("/admin");
    }

}


