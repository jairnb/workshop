package com.workshop.company.service;

import com.workshop.company.entity.File;
import com.workshop.company.repository.IFileRepository;
import com.workshop.company.utility.IFileStore;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import jakarta.transaction.Transactional;
import java.io.IOException;
import java.util.*;

import static org.apache.http.entity.ContentType.*;

//@Service
//@Transactional
public class FileService implements IFileService {
    private IFileRepository fileRepository;
    private IFileStore fileStore;

//    @Value("${aws.bucket}")
    private String bucketName;

    public FileService(IFileRepository fileRepository, IFileStore fileStore) {
        this.fileRepository = fileRepository;
        this.fileStore = fileStore;
    }


    @Override
    public File saveFile(String title, String description, MultipartFile file) {
        //check if the file is empty
        if (file.isEmpty()) {
            throw new IllegalStateException("Cannot upload empty file");
        }

        if (!Arrays.asList(IMAGE_PNG.getMimeType(),
                IMAGE_BMP.getMimeType(),
                IMAGE_GIF.getMimeType(),
                IMAGE_JPEG.getMimeType()).contains(file.getContentType())) {
            throw new IllegalStateException("FIle uploaded is not an image");
        }

        Map<String, String> metadata = new HashMap<>();
        metadata.put("Content-Type", file.getContentType());
        metadata.put("Content-Length", String.valueOf(file.getSize()));
        //Save Image in S3 and then save Todo in the database
        String path = String.format("%s/%s", bucketName, UUID.randomUUID());
        String fileName = String.format("%s", file.getOriginalFilename());
        try {
            fileStore.upload(path, fileName, Optional.of(metadata), file.getInputStream());
        } catch (IOException e) {
            throw new IllegalStateException("Failed to upload file", e);
        }

        File file1 = File.builder()
                .description(description)
                .title(title)
                .filePath(path)
                .fileName(fileName)
                .build();

        fileRepository.save(file1);

        return fileRepository.findByTitle(fileName);
    }

    @Override
    public byte[] downloadFileById(UUID id) {
        File file = fileRepository.findById(id).get();

        return fileStore.download(file.getFilePath(), file.getFileName());
    }

    @Override
    public List<File> getAllFiles() {
        return fileRepository.findAll();
    }
}
