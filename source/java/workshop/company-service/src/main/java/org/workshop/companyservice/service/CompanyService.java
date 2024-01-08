package org.workshop.companyservice.service;

import org.workshop.companyservice.entity.Company;

public interface CompanyService {
    Company save(Company company);
    Iterable<Company> findAll();
}
