package com.kenzan.codechallenge.kcodechallenge.service;

import com.kenzan.codechallenge.kcodechallenge.model.Employee;
import com.kenzan.codechallenge.kcodechallenge.model.EmployeeResponse;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    List<Employee> getEmployees() throws Exception;
    Optional<Employee> getEmployeeById(int employeeId) throws Exception;
    EmployeeResponse saveEmployee(Employee employee) throws Exception;
    EmployeeResponse updateEmployee(Employee employee) throws Exception;
    EmployeeResponse deleteEmployee(int employeeId) throws Exception;
}
