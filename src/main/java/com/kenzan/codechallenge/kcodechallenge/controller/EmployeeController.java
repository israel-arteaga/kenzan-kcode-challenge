package com.kenzan.codechallenge.kcodechallenge.controller;

import com.kenzan.codechallenge.kcodechallenge.model.*;
import com.kenzan.codechallenge.kcodechallenge.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/employees")
public class EmployeeController {
    private Logger LOG = LoggerFactory.getLogger("EmployeeController");

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "/getAll", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public EmployeeListWrapper getEmployees() throws Exception {
        EmployeeListWrapper employeeListWrapper = new EmployeeListWrapper();
        LOG.info("number of employees controller: " + employeeService.getEmployees().size());
        employeeListWrapper.setEmployees(employeeService.getEmployees());

        return employeeListWrapper;
    }

    @RequestMapping(value = "/getById/{employee_id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public EmployeeWrapper getEmployeeById(@PathVariable("employee_id") String employee_id) throws Exception {
        EmployeeWrapper employeeWrapper = new EmployeeWrapper();
        Optional<Employee> employee = employeeService.getEmployeeById(Integer.parseInt(employee_id));
        employeeWrapper.setEmployee(employee);

        return employeeWrapper;
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public EmployeeResponse addEmployee(@RequestBody Employee employeeRequest) throws Exception {
        EmployeeResponse employeeResponse = employeeService.saveEmployee(employeeRequest);

        return employeeResponse;
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public EmployeeResponse updateEmployee(@RequestBody Employee employeeRequest) throws Exception {
        EmployeeResponse employeeResponse = employeeService.updateEmployee(employeeRequest);

        return employeeResponse;
    }

    @RequestMapping(value = "/delete/{employee_id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public EmployeeResponse deleteEmployee(@PathVariable("employee_id") String employee_id) throws Exception {
        EmployeeResponse employeeResponse = employeeService.deleteEmployee(Integer.parseInt(employee_id));

        return employeeResponse;
    }
}
