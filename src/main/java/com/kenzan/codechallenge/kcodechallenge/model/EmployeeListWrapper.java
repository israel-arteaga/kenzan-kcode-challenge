package com.kenzan.codechallenge.kcodechallenge.model;

import java.util.List;

public class EmployeeListWrapper {
    private List<Employee> employees;

    public EmployeeListWrapper() {
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
