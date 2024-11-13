package com.workshop.employeeservice.service;

import com.workshop.employeeservice.dto.EmployeeList;
import com.workshop.employeeservice.entity.Employee;

import java.util.UUID;

public interface EmployeeService {
    Employee save(Employee employee);
    Employee findById(UUID uuid);
    EmployeeList findAll();
    Employee update(UUID id, Employee employee) throws Exception;
    void delete(UUID uuid) throws Exception;
}
