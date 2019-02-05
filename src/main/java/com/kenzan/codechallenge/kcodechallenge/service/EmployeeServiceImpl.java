package com.kenzan.codechallenge.kcodechallenge.service;

import com.kenzan.codechallenge.kcodechallenge.model.Employee;
import com.kenzan.codechallenge.kcodechallenge.model.EmployeeResponse;
import com.kenzan.codechallenge.kcodechallenge.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private Logger LOG = LoggerFactory.getLogger("EmployeeServiceImpl");

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getEmployees() {
        LOG.info("number of employees: " + employeeRepository.count());
        return employeeRepository.findAll().stream().filter(e -> e.isStatus() == true).collect(Collectors.toList());
    }

    @Override
    public Optional<Employee> getEmployeeById(int employeeId) throws Exception {
        Optional<Employee> employee = employeeRepository.findById(employeeId).filter(e -> e.isStatus() == true);
        return employee;
    }

    @Override
    public EmployeeResponse saveEmployee(Employee employee) throws Exception {
        EmployeeResponse employeeResponse = new EmployeeResponse();
        Optional<Employee> exists= getEmployeeById(employee.getId());
        LOG.info("exists: " + exists);

        if (!exists.equals(Optional.empty())){
            employeeResponse.setSuccess(false);
            employeeResponse.setMessage("Employee already exists");
            return employeeResponse;
        }
        Employee savedEmployee = employeeRepository.save(employee);
        if(savedEmployee!=null){
            employeeResponse.setSuccess(true);
            employeeResponse.setMessage("Employee successfully added");
        }else{
            employeeResponse.setSuccess(false);
            employeeResponse.setMessage("Employee was not added, an error occurred");
        }

        return employeeResponse;
    }

    @Override
    public EmployeeResponse updateEmployee(Employee employee) throws Exception {
        EmployeeResponse employeeResponse = new EmployeeResponse();

        Employee savedEmployee = employeeRepository.save(employee);

        if(savedEmployee!=null){
            employeeResponse.setSuccess(true);
            employeeResponse.setMessage("Employee successfully updated");
        }else{
            employeeResponse.setSuccess(false);
            employeeResponse.setMessage("Employee was not updated, an error occurred");
        }

        return employeeResponse;
    }

    @Override
    public EmployeeResponse deleteEmployee(int employeeId) throws Exception {
        EmployeeResponse employeeResponse = new EmployeeResponse();
        Optional<Employee> exists= getEmployeeById(employeeId);
        if (exists.equals(Optional.empty())){
            employeeResponse.setSuccess(false);
            employeeResponse.setMessage("Employee that you are trying to delete does not exist");
            return employeeResponse;
        }
        employeeRepository.deleteById(employeeId);
        Optional<Employee> employee = getEmployeeById(employeeId);

        if (employee.equals(Optional.empty())){
            employeeResponse.setSuccess(true);
            employeeResponse.setMessage("Employee successfully deleted");
        }else{
            employeeResponse.setSuccess(false);
            employeeResponse.setMessage("Employee was not deleted, an error occurred");
        }

        return employeeResponse;
    }

}
