package com.workshop.company.service;

import com.workshop.company.dto.CompanyDTO;
import com.workshop.company.dto.CompanyListDTO;
import com.workshop.company.dto.CompanySaveDTO;
import com.workshop.company.entity.Company;
import com.workshop.company.repository.ICompanyRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@AllArgsConstructor
public class CompanyService implements ICompanyService {

    private final ICompanyRepository companyRepository;
    private final ModelMapper modelMapper;

    @Override
    public CompanyDTO save(CompanySaveDTO c) {
        var company = modelMapper.map(c, Company.class);
        company.setCreatedAt(LocalDateTime.now());
        var res = companyRepository.save(company);
        return modelMapper.map(res, CompanyDTO.class);
    }

    @Override
    public CompanyDTO findById(UUID uuid) {
        var company = companyRepository.findById(uuid);
        if(company.isPresent()) return modelMapper.map(company.get(), CompanyDTO.class);
        return null;
    }

    @Override
    public CompanyListDTO findAll() {
        var r = companyRepository.findAll().stream().map(c -> modelMapper.map(c, CompanyDTO.class)).toList();
        CompanyListDTO companyListDTO = new CompanyListDTO(r);
        return companyListDTO;
    }
}
