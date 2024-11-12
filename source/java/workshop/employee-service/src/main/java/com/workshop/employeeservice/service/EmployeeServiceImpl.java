package com.workshop.employeeservice.service;

import com.workshop.employeeservice.dto.EmployeeList;
import com.workshop.employeeservice.entity.Employee;
import com.workshop.employeeservice.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;


    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public EmployeeList findAll() {
        List<Employee> employeeList =  employeeRepository.findAll();
        return new EmployeeList(employeeList);
    }
}
