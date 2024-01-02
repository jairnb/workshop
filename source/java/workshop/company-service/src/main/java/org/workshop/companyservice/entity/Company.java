package org.workshop.companyservice.entity;


import lombok.Data;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class Company {
    @Id
    private UUID id;
    private String name;
    private long phoneNumber;
    private LocalDateTime createdAt;
    private LocalDateTime deletedAt;
}
