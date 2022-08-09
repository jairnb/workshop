package com.workshop.company.repository;

import com.workshop.company.entity.File;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IFileRepository extends JpaRepository<File, UUID> {
    File findByTitle(String title);
}
