package com.workshop.departmentservice.service;

import com.workshop.departmentservice.entity.Department;

import java.util.List;

public interface DepartmentService {
    List<Department> findAll();
    Department save(Department department);
}
