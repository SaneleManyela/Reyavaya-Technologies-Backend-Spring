package com.reyavaya.Reyavaya.Technologies.repository;

import com.reyavaya.Reyavaya.Technologies.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    public Employee findByUsernameAndPassword(String username, String password);
    public Employee findByUsername(String username);
}
 