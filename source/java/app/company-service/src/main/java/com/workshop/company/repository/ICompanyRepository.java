package com.workshop.company.repository;

import com.workshop.company.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ICompanyRepository extends JpaRepository<Company, UUID> {
}
