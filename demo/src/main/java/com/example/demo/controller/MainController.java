package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String home() {
        return "webapp";
    }

    @GetMapping("/login")
    public String login() {
        return "login.html";
    }

    /*@GetMapping("/admin")
    public String admin() {
        return "admin.html";
    }*/

    @GetMapping("/add")
    public String add() {
        return "add.html";
    }

    /*@GetMapping("/update")
    public String update() {
        return "edit.html";
    }*/

    /*@GetMapping("/employee")
    public String employee() {
        return "employee.html";
    }*/

    
}
