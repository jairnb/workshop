package org.workshop.companyservice.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.jdbc.core.mapping.AggregateReference;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class Address {
    @Id
    private UUID id;
    AggregateReference<Company, UUID> company;
    private String streetAddress;
    private String streetAddress2;
    private String streetAddress3;
    private String city;
    private String state;
    private String zip;
    private String country;
    private String county;
    private long latitude;
    private long longitude;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
