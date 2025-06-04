package com.workshop.companyservice.service;

import com.workshop.companyservice.dto.CompanyList;
import com.workshop.companyservice.entity.Company;

import java.util.UUID;

public interface CompanyService {
    Company save(Company company);
    Company findById(UUID uuid);
    CompanyList findAll();
    Company update(UUID id, Company company) throws Exception;
    void delete(UUID uuid) throws Exception;

}
