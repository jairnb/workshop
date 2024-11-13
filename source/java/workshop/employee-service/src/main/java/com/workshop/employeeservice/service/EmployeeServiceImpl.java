package com.workshop.employeeservice.service;

import com.workshop.employeeservice.dto.EmployeeList;
import com.workshop.employeeservice.entity.Employee;
import com.workshop.employeeservice.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);


    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee save(Employee employee) {
        logger.info("EmployeeServiceImpl::save Entered");
        employee.setCreatedAt(LocalDateTime.now());
        employee.setUpdatedAt(LocalDateTime.now());

        return employeeRepository.save(employee);
    }

    @Override
    public Employee findById(UUID uuid) {
        logger.info("EmployeeServiceImpl::findById Entered");
        Optional<Employee> employee = employeeRepository.findById(uuid);
        return employee.orElse(null);
    }

    @Override
    public EmployeeList findAll() {
        logger.info("EmployeeServiceImpl::findById findAll");

        List<Employee> employeeList =  employeeRepository.findAll();
        return new EmployeeList(employeeList);
    }

    @Override
    public Employee update(UUID id, Employee employee) throws Exception {
        return null;
    }

    @Override
    public void delete(UUID uuid) throws Exception {
        logger.info("EmployeeServiceImpl::delete findAll");

        Optional<Employee> employee = employeeRepository.findById(uuid);
        if (employee.isEmpty()) throw new Exception();
        employee.get().setDeletedAt(LocalDateTime.now());
        employeeRepository.save(employee.get());
    }
}
