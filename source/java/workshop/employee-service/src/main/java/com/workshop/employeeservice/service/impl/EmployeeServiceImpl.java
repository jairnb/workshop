package com.workshop.employeeservice.service.impl;

import com.workshop.employeeservice.entity.Employee;
import com.workshop.employeeservice.repository.EmployeeRepository;
import com.workshop.employeeservice.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }
}
