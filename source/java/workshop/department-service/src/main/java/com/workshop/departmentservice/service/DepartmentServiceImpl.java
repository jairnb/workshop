package com.workshop.departmentservice.service;

import com.workshop.departmentservice.entity.Department;
import com.workshop.departmentservice.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public List<Department> findAll() {
        return departmentRepository.findAll();
    }

    @Override
    public Department save(Department department) {
        department.setCreatedAt(LocalDateTime.now());
        Department save = departmentRepository.save(department);
        return save;
    }
}
