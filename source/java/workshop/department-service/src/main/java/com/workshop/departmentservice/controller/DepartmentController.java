package com.workshop.departmentservice.controller;

import com.workshop.departmentservice.entity.Department;
import com.workshop.departmentservice.service.DepartmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/department")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(departmentService.findAll());
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Department department) {
        Department save = departmentService.save(department);
        return ResponseEntity.ok(save);
    }
}
