package org.workshop.companyservice.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.workshop.companyservice.entity.Company;

import java.util.UUID;

@Repository
public interface CompanyRepository extends CrudRepository<Company, UUID> {
}
