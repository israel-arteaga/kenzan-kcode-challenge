package com.kenzan.codechallenge.kcodechallenge.controller;

import com.google.gson.Gson;
import com.kenzan.codechallenge.kcodechallenge.model.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.sql.Date;
import java.text.SimpleDateFormat;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getAllEmployeesShouldReturnAllActiveEmployees() throws Exception {
        this.mockMvc.perform(get("/employees/getAll"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.employees").isNotEmpty())
                .andExpect(jsonPath("$.employees[0].status").value(true))
                .andExpect(jsonPath("$.employees[1].status").value(true))
                .andExpect(jsonPath("$.employees[2].status").value(true))
                .andExpect(jsonPath("$.employees[3].status").value(true));
    }

    @Test
    public void getEmployeeByIdShouldReturnActiveEmployee() throws Exception {
        this.mockMvc.perform(get("/employees/getById/1"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.employee").isNotEmpty())
                .andExpect(jsonPath("$.employee.id").value("1"))
                .andExpect(jsonPath("$.employee.status").value(true));
    }


    @Test
    public void addEmployeeShouldReturnSuccessValue() throws Exception {

        Employee employeeRequest = new Employee();
        employeeRequest.setId(10);
        employeeRequest.setFirstName("Dikembe");
        employeeRequest.setMiddleInitial("M");
        employeeRequest.setLastName("Vampeta");
        // employeeRequest.setDateOfBirth(new Date(1977, 04, 14));
        //employeeRequest.setDateOfEmployement(new Date(2019, 01, 01));
        employeeRequest.setStatus(true);

        Gson gson = new Gson();
        String json = gson.toJson(employeeRequest);

        this.mockMvc.perform(post("/employees/new").contentType(MediaType.APPLICATION_JSON).content(json))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.success").value(true));
    }

    @Test
    public void updateEmployeeShouldReturnSuccessValue() throws Exception {

        Employee employeeRequest = new Employee();
        employeeRequest.setId(10);
        employeeRequest.setFirstName("Dikembe");
        employeeRequest.setMiddleInitial("Mutombo");
        employeeRequest.setLastName("Vampeta");
        // employeeRequest.setDateOfBirth(new Date(1977, 04, 14));
        //employeeRequest.setDateOfEmployement(new Date(2019, 01, 01));
        employeeRequest.setStatus(false);

        Gson gson = new Gson();
        String json = gson.toJson(employeeRequest);

        this.mockMvc.perform(put("/employees/update").contentType(MediaType.APPLICATION_JSON).content(json))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.success").value(true));
    }

    @Test
    public void deleteEmployeeShouldReturnSuccessValue() throws Exception {

        this.mockMvc.perform(delete("/employees/delete/2"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.success").value(true));
    }
}
