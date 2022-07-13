package com.workshop.company.service;

import com.workshop.company.dto.CompanyDTO;
import com.workshop.company.dto.CompanyListDTO;
import com.workshop.company.dto.CompanySaveDTO;

import java.util.UUID;

public interface ICompanyService {
    CompanyDTO save(CompanySaveDTO c);
    CompanyDTO findById(UUID uuid);
    CompanyListDTO findAll();
}
