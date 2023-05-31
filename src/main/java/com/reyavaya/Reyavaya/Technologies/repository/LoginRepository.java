package com.reyavaya.Reyavaya.Technologies.repository;

import com.reyavaya.Reyavaya.Technologies.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepository extends JpaRepository<Employee, Long> {
    public Employee findByUsername(String username);
}
