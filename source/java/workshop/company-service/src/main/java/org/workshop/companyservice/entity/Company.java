package org.workshop.companyservice.entity;


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
public class Company {
    @Id
    private UUID id;
    private String name;
    private String companyIdentifier;
    private long phoneNumber;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    @JsonIgnore
    private LocalDateTime deletedAt;

    @MappedCollection(idColumn = "company")
    private Set<Address> address;

}
