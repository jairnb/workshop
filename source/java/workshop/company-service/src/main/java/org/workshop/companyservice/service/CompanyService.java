package org.workshop.companyservice.service;

import org.workshop.companyservice.entity.Company;

import java.util.List;

public interface CompanyService {
    Company save(Company company);
    List<Company> findAll();
}
