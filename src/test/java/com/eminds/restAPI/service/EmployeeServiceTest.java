package com.eminds.restAPI.service;

import com.eminds.restAPI.entity.Employee;
import com.eminds.restAPI.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.extension.ExtendWith;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {

    @InjectMocks
    private EmployeeServiceImpl employeeService;

    @Mock
    private EmployeeRepository employeeRepository;

    @Test
    public void testGetAllEmployees() {
        List<Employee> employees = Arrays.asList(
                new Employee(1L, "Navaneetha", "krishnan", "naveensaravana8@gmail.com", "Data Engineer"),
                new Employee(2L, "Ramanathan", "Ganesan", "ramanathan@gmail.com", "Robotics")
        );

        when(employeeRepository.findAll()).thenReturn(employees);

        List<Employee> result = employeeService.getAllEmployees();
        assertEquals(2, result.size());
        assertEquals("Navaneetha", result.get(0).getFirstName());
    }

    @Test
    public void testCreateEmployee() {
        Employee employee = new Employee(1L, "Hari", "Saravanan", "harisaravana92@gmail.com", "QA");

        when(employeeRepository.save(Mockito.any(Employee.class))).thenReturn(employee);

        Employee result = employeeService.saveEmployee(employee);
        assertNotNull(result);
        assertEquals("Hari", result.getFirstName());
    }

    @Test
    public void testGetEmployeeById() {
        Employee employee = new Employee(1L, "Bala", "Srinivasan", "balasrinivasan@gmail.com", "DBA");

        when(employeeRepository.findById(1L)).thenReturn(Optional.of(employee));

        Employee result = employeeService.getEmployeeById(1L);
        assertNotNull(result);
        assertEquals("Bala", result.getFirstName());
    }
}

