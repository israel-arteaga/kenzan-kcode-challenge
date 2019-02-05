package com.kenzan.codechallenge.kcodechallenge.repository;

import com.kenzan.codechallenge.kcodechallenge.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
