package org.workshop.companyservice.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.workshop.companyservice.dto.CompanyDTO;
import org.workshop.companyservice.dto.CompanyListDTO;
import org.workshop.companyservice.entity.Company;
import org.workshop.companyservice.repository.CompanyRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CompanyServiceImpl implements CompanyService {
    private final CompanyRepository companyRepository;
    private final ModelMapper modelMapper;

    public CompanyServiceImpl(CompanyRepository companyRepository, ModelMapper modelMapper) {
        this.companyRepository = companyRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public CompanyDTO save(CompanyDTO companyDTO) {
        Company company = modelMapper.map(companyDTO, Company.class);
        company.getAddress().forEach(
                address -> {
                    address.setCreatedAt(LocalDateTime.now());
                    address.setUpdatedAt(LocalDateTime.now());
                }
        );
        company.setCreatedAt(LocalDateTime.now());
        company.setUpdatedAt(LocalDateTime.now());
        Company result = companyRepository.save(company);

        return modelMapper.map(result, CompanyDTO.class);
    }

    @Override
    public CompanyDTO findById(UUID uuid) {
        Optional<Company> company = companyRepository.findById(uuid);
        return company.map(value -> modelMapper.map(value, CompanyDTO.class)).orElse(null);
    }

    @Override
    public CompanyListDTO findAll() {
        List<CompanyDTO> companyDTOList = companyRepository.findAll().stream().map(company -> modelMapper.map(company, CompanyDTO.class)).toList();
        return new CompanyListDTO(companyDTOList);
    }

    @Override
    public CompanyDTO update(UUID uuid, CompanyDTO companyDTO) throws Exception {
        Optional<Company> companyOptional = companyRepository.findById(uuid);

        if (companyOptional.isEmpty()) throw new Exception();
        Company company = companyOptional.get();
        company.setName(companyDTO.getName());
        return null;
    }

    @Override
    public void delete(UUID uuid) throws Exception {
        Optional<Company> companyOptional = companyRepository.findById(uuid);

        if (companyOptional.isEmpty()) throw new Exception();
        companyOptional.get().setDeletedAt(LocalDateTime.now());
        companyRepository.save(companyOptional.get());
    }
}
