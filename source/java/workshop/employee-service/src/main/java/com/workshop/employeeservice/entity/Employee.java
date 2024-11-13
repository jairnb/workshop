package com.workshop.employeeservice.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    @Id
    private UUID id;
    private String firstName;
    private String lastName;
    private String middleName;
    private String companyId;
    private long phoneNumber;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    @JsonIgnore
    private LocalDateTime deletedAt;

    @MappedCollection(idColumn = "employee")
    private Set<Address> address;

}
