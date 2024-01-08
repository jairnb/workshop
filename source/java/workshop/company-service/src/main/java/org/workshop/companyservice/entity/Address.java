package org.workshop.companyservice.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Address {
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
