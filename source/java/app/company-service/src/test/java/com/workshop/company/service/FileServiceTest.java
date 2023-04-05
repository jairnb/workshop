package com.workshop.company.service;

import com.workshop.company.repository.IFileRepository;
import com.workshop.company.utility.IFileStore;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;

class FileServiceTest {

    @Mock
    private IFileRepository iFileRepository;
    @Mock
    private IFileStore fileStore;

    private FileService underTest;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        underTest = new FileService(iFileRepository, fileStore);
    }
    @Test
    void saveFile() {
    }

    @Test
    void downloadFileById() {
    }

    @Test
    void getAllFiles() {
    }
}