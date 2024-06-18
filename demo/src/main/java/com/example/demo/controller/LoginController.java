package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;

@Controller
public class LoginController {

     @Autowired
    private EmployeeRepository employeeRepository;

    @PostMapping("/authenticate")
    public ModelAndView authenticate(@RequestParam("module") String module, 
                                     @RequestParam("username") String username, 
                                     @RequestParam("password") String password) {
        ModelAndView modelAndView;
        if (module.equals("admin") && "admin".equals(username) && "ADMIN@123".equals(password)) {
            modelAndView = new ModelAndView(new RedirectView("/admin"));
        } else if (module.equals("employee")) {
            modelAndView = new ModelAndView("login");
            Employee employee = employeeRepository.findByUsernameAndPassword(username, password);
            if (employee != null && module.equals("employee")) {
                modelAndView = new ModelAndView(new RedirectView("/employee"));
                modelAndView.addObject("username", username);
            } else {
                modelAndView.addObject("alertScript", "alert('Invalid username or password!');");
            }
        }else {
            modelAndView = new ModelAndView("login");
            modelAndView.addObject("alertScript", "alert('Invalid username or password!');");
        }
        return modelAndView;
    }
}
