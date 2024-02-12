package org.workshop.companyservice.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CompanyDTO {
    private UUID id;
    @NotBlank
    private String name;
    private String companyIdentifier;
    private long phoneNumber;
    private Set<AddressDTO> address;
}
