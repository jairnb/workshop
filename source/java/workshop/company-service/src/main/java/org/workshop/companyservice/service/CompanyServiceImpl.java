package org.workshop.companyservice.service;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.workshop.companyservice.dto.CompanyList;
import org.workshop.companyservice.entity.Address;
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
    private final Logger logger = LoggerFactory.getLogger(CompanyServiceImpl.class);

    public CompanyServiceImpl(CompanyRepository companyRepository, ModelMapper modelMapper) {
        this.companyRepository = companyRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Company save(Company companyDTO) {
        logger.info("CompanyServiceImpl::save Entered");
        Company company = modelMapper.map(companyDTO, Company.class);
//        company.getAddress().forEach(
//                address -> {
//                    address.setCreatedAt(LocalDateTime.now());
//                    address.setUpdatedAt(LocalDateTime.now());
//                }
//        );
        company.setCreatedAt(LocalDateTime.now());
        company.setUpdatedAt(LocalDateTime.now());
        Company result = companyRepository.save(company);

        return modelMapper.map(result, Company.class);
    }

    @Override
    public Company findById(UUID uuid) {
        logger.info("CompanyServiceImpl::findById Entered");
        Optional<Company> company = companyRepository.findById(uuid);
        return company.map(value -> modelMapper.map(value, Company.class)).orElse(null);
    }

    @Override
    public CompanyList findAll() {
        logger.info("Enter CompanyServiceImpl::findAll");
        List<Company> companies = companyRepository.findAll();
        return new CompanyList(companies);
    }

    @Override
    public Company update(UUID uuid, Company companyDTO) throws Exception {
        logger.info("CompanyServiceImpl::update Entered");
        Optional<Company> companyOptional = companyRepository.findById(uuid);

        //TODO: Review thr exception
        if (companyOptional.isEmpty()) throw new Exception();
        Company company = companyOptional.get();
        company.setName(companyDTO.getName());
        company.setCompanyIdentifier(companyDTO.getCompanyIdentifier());
        company.setPhoneNumber(companyDTO.getPhoneNumber());
        company.setUpdatedAt(LocalDateTime.now());

        for (Address address : company.getAddress()) {
            Optional<Address> addressToUpdate = companyDTO.getAddress().stream().filter(c -> c.getId().equals(address.getId())).findFirst();

            addressToUpdate.ifPresent(dto -> {
                address.setStreetAddress(dto.getStreetAddress());
                address.setStreetAddress2(dto.getStreetAddress2());
                address.setStreetAddress3(dto.getStreetAddress3());
                address.setCity(dto.getCity());
                address.setState(dto.getState());
                address.setZip(dto.getZip());
                address.setCountry(dto.getCountry());
                address.setCounty(dto.getCounty());
                address.setLatitude(dto.getLatitude());
                address.setLongitude(dto.getLongitude());
                address.setUpdatedAt(LocalDateTime.now());
            });
        }
        Company result = companyRepository.save(company);

        return modelMapper.map(result, Company.class);
    }

    @Override
    public void delete(UUID uuid) throws Exception {
        logger.info("CompanyServiceImpl::delete Entered");
        Optional<Company> companyOptional = companyRepository.findById(uuid);

        //TODO: Review thr exception
        if (companyOptional.isEmpty()) throw new Exception();
        companyOptional.get().setDeletedAt(LocalDateTime.now());
        companyRepository.save(companyOptional.get());
    }
}
