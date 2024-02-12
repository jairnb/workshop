package org.workshop.companyservice.repository;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;
import org.workshop.companyservice.entity.Company;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface CompanyRepository extends ListCrudRepository<Company, UUID> {

    @Override
    @Query("SELECT * FROM company WHERE  deleted_at isnull")
    List<Company> findAll();

    @Override
    @Query("SELECT * FROM company WHERE  deleted_at isnull and id = :id")
    Optional<Company> findById(UUID id);
}
