package com.workshop.employeeservice.dto;

import com.workshop.employeeservice.entity.Employee;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EmployeeList {
    private List<Employee> employees;
}
