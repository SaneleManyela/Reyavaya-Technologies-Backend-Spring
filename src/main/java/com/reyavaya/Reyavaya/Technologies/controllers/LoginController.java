package com.reyavaya.Reyavaya.Technologies.controllers;

import com.reyavaya.Reyavaya.Technologies.model.Employee;
import com.reyavaya.Reyavaya.Technologies.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class LoginController {
    @Autowired
    private LoginRepository loginRepository;

    @PostMapping("/login")
    public boolean login(@RequestBody LinkedHashMap<String, String> employee) {
        System.out.println(employee);
        Employee emp = loginRepository.findByUsername(employee.get("username"));
        boolean isLogged = false;
        if(emp != null) {
            isLogged = emp.getPassword().equals(employee.get("password"));
        }
        return isLogged;
    }
}
