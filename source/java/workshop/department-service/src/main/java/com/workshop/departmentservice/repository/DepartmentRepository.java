package com.workshop.departmentservice.repository;

import com.workshop.departmentservice.entity.Department;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface DepartmentRepository extends ListCrudRepository<Department, UUID> {

    @Override
    @Query("SELECT * FROM department WHERE  deleted_at isnull")
    List<Department> findAll();
}
