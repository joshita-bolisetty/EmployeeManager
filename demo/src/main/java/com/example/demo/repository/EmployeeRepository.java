package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    boolean existsByUsername(String username);
    void deleteById(Long id);
    Employee findByUsername(String username);
    Employee findByUsernameAndPassword(String username, String password);
}
