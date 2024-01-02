package com.workshop.employeeservice.repository;

import com.workshop.employeeservice.entity.Employee;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EmployeeRepository extends ListCrudRepository<Employee, UUID> {
}
