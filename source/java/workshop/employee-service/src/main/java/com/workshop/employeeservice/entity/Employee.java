package com.workshop.employeeservice.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.UUID;

@Data
public class Employee {
    @Id
    private UUID id;

    private String name;
}
