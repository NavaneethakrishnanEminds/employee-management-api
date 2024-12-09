package com.eminds.restAPI.controller;

import com.eminds.restAPI.entity.Employee;
import com.eminds.restAPI.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(EmployeeController.class)
public class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmployeeService employeeService;

    @Test
    public void testGetAllEmployees() throws Exception {
        List<Employee> employees = Arrays.asList(
                new Employee(1L, "Navaneetha", "krishnan", "Navaneetha.krishnan@example.com", "Data Engineering"),
                new Employee(2L, "Hari", "haran", "Hari.haran@example.com", "Marketing")
        );

        Mockito.when(employeeService.getAllEmployees()).thenReturn(employees);

        mockMvc.perform(get("/api/employees")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].firstName", is("Navaneetha")))
                .andExpect(jsonPath("$[1].email", is("Hari.haran@example.com")));
    }

    @Test
    public void testCreateEmployee() throws Exception {
        Employee employee = new Employee(1L, "Navaneetha", "krishnan", "Navaneetha.krishnan@example.com", "Data Engineering");

        Mockito.when(employeeService.saveEmployee(Mockito.any(Employee.class))).thenReturn(employee);

        mockMvc.perform(post("/api/employees/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"firstName\":\"Navaneetha\",\"lastName\":\"krishnan\",\"email\":\"Navaneetha.krishnan@example.com\",\"team\":\"Engineering\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstName", is("Navaneetha")))
                .andExpect(jsonPath("$.email", is("Navaneetha.krishnan@example.com")))
                .andExpect(jsonPath("$.team", is("Data Engineering")));
    }

}

