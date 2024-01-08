package org.workshop.companyservice.service;

import org.springframework.stereotype.Service;
import org.workshop.companyservice.entity.Company;
import org.workshop.companyservice.repository.CompanyRepository;

@Service
public class CompanyServiceImpl implements CompanyService {
    private final CompanyRepository companyRepository;

    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public Company save(Company company) {
        return companyRepository.save(company);
    }

    @Override
    public Iterable<Company> findAll() {
        return companyRepository.findAll();
    }
}
