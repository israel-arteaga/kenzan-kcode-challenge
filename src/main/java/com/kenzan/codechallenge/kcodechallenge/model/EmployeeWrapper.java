package com.kenzan.codechallenge.kcodechallenge.model;

import java.util.List;
import java.util.Optional;

public class EmployeeWrapper {
    private Optional<Employee>  employee;

    public EmployeeWrapper() {
    }

    public Optional<Employee> getEmployee() {
        return employee;
    }

    public void setEmployee(Optional<Employee> employee) {
        this.employee = employee;
    }
}
