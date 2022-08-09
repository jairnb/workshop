package com.workshop.company.controller;

import com.workshop.company.dto.CompanyDTO;
import com.workshop.company.dto.CompanyListDTO;
import com.workshop.company.dto.CompanySaveDTO;
import com.workshop.company.entity.File;
import com.workshop.company.service.ICompanyService;
import com.workshop.company.service.IFileService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/companies")
public class CompanyController {
    private final ICompanyService companyService;
    private final IFileService fileService;

    public CompanyController(ICompanyService companyService, IFileService fileService) {
        this.companyService = companyService;
        this.fileService = fileService;
    }

    @PostMapping
    public ResponseEntity<CompanyDTO> save(@Valid @RequestBody CompanySaveDTO c){
        var r = companyService.save(c);
        return new ResponseEntity<>(r, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<CompanyListDTO> findAll(){
        return new ResponseEntity<>(companyService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CompanyDTO> findById(@PathVariable UUID id){
        return new ResponseEntity<>(companyService.findById(id), HttpStatus.OK);
    }

    @PostMapping(
            path = "/file",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<File> saveTodo(@RequestParam("title") String title,
                                         @RequestParam("description") String description,
                                         @RequestParam("file") MultipartFile file) {
        return new ResponseEntity<>(fileService.saveFile(title, description, file), HttpStatus.OK);
    }
}
