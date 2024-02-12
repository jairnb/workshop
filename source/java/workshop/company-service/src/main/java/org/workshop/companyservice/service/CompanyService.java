package org.workshop.companyservice.service;

import org.workshop.companyservice.dto.CompanyDTO;
import org.workshop.companyservice.dto.CompanyListDTO;

import java.util.UUID;

public interface CompanyService {
    CompanyDTO save(CompanyDTO company);
    CompanyDTO findById(UUID uuid);
    CompanyListDTO findAll();
    CompanyDTO update(UUID id, CompanyDTO company) throws Exception;
    void delete(UUID uuid) throws Exception;
}
