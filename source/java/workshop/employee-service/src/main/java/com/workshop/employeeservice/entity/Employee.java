package com.workshop.employeeservice.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.jdbc.core.mapping.AggregateReference;

import java.time.LocalDate;
import java.time.LocalDateTime;
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
    private String email;
    private String ssn;
    private LocalDate birthdate;
    private LocalDate hireDate;
    private boolean status;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    @JsonIgnore
    private LocalDateTime deletedAt;

//    @MappedCollection(idColumn="id", keyColumn="employee")
//    private Address address;

    AggregateReference<Address,Long> address;

}
