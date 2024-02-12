package org.workshop.companyservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AddressDTO {
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
}
