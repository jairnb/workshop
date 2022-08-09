package com.workshop.company.service;

import com.workshop.company.entity.File;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;

public interface IFileService {
    File saveFile(String title, String description, MultipartFile file);

    byte[] downloadFileById(UUID id);

    List<File> getAllFiles();
}
