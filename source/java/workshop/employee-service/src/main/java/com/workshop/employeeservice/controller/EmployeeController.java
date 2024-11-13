package com.workshop.employeeservice.controller;

import com.workshop.employeeservice.dto.EmployeeList;
import com.workshop.employeeservice.entity.Employee;
import com.workshop.employeeservice.service.EmployeeService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {

    private final EmployeeService employeeService;
    private final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public ResponseEntity<Employee> save(@Valid @RequestBody Employee employee) {
        logger.info("EmployeeController::save Entered");
        return new ResponseEntity<>(employeeService.save(employee), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<EmployeeList> findAll() {
        logger.info("EmployeeController::findAll Entered");
        EmployeeList all = employeeService.findAll();
        return new ResponseEntity<>(all, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> findById(@PathVariable UUID id){
        logger.info("EmployeeController::findById Entered");
        Employee employee = employeeService.findById(id);
        return (employee != null) ? new ResponseEntity<>(employee, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable UUID id, @Valid @RequestBody Employee employee) throws Exception {
        logger.info("EmployeeController::update Entered");
        Employee employeeToUpdate = employeeService.update(id, employee);
        return (employeeToUpdate != null) ? new ResponseEntity<>(employeeToUpdate, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable UUID id) throws Exception {
        logger.info("EmployeeController::delete Entered");
        employeeService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
