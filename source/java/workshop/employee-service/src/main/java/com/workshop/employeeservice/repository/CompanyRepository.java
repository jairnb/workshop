package com.workshop.employeeservice.repository;

import com.workshop.employeeservice.entity.Employee;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface CompanyRepository extends ListCrudRepository<Employee, UUID> {

    @Override
    @Query("SELECT * FROM company WHERE  deleted_at isnull")
    List<Employee> findAll();

    @Override
    @Query("SELECT * FROM company WHERE  deleted_at isnull and id = :id")
    Optional<Employee> findById(UUID id);
}
