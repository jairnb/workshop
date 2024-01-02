package com.workshop.employeeservice.service;

import com.workshop.employeeservice.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();
}
