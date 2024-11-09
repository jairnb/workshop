package org.workshop.companyservice.service;

import org.workshop.companyservice.dto.CompanyList;
import org.workshop.companyservice.entity.Company;

import java.util.UUID;

public interface CompanyService {
    Company save(Company company);
    Company findById(UUID uuid);
    CompanyList findAll();
    Company update(UUID id, Company company) throws Exception;
    void delete(UUID uuid) throws Exception;
}
