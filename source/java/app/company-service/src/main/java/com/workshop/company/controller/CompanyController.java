package com.workshop.company.controller;

import com.workshop.company.dto.CompanyDTO;
import com.workshop.company.dto.CompanyListDTO;
import com.workshop.company.dto.CompanySaveDTO;
import com.workshop.company.service.ICompanyService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/companies")
public class CompanyController {
    private final ICompanyService companyService;

    @Value("${cloud.aws.credentials.accessKey}")
    private String ab;

    public CompanyController(ICompanyService companyService) {
        this.companyService = companyService;
    }

    @PostMapping
    public ResponseEntity<CompanyDTO> save(@Valid @RequestBody CompanySaveDTO c){
        var r = companyService.save(c);
        return new ResponseEntity<>(r, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<CompanyListDTO> findAll(){
        System.out.println(ab);
        return new ResponseEntity<>(companyService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CompanyDTO> findById(@PathVariable UUID id){
        return new ResponseEntity<>(companyService.findById(id), HttpStatus.OK);
    }
}
