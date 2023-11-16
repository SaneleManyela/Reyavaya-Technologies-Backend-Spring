package com.reyavaya.Reyavaya.Technologies.controllers;

import com.reyavaya.Reyavaya.Technologies.model.Employee;
import com.reyavaya.Reyavaya.Technologies.repository.LoginRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class LoginController {
    private final LoginRepository loginRepository;

    public LoginController(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    @PostMapping("/login")
    public ResponseEntity<Employee> login(@RequestBody LinkedHashMap<String, String> employee) {
        System.out.println(employee);
        Employee emp = loginRepository.findByUsernameAndPassword(employee.get("username"), employee.get("password"));
        return ResponseEntity.ok(emp);
    }
}
