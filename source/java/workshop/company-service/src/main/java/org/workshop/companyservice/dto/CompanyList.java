package org.workshop.companyservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.workshop.companyservice.entity.Company;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CompanyList {
    private List<Company> companies;
}
