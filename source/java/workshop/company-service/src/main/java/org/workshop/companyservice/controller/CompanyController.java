package org.workshop.companyservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.workshop.companyservice.entity.Company;
import org.workshop.companyservice.service.CompanyService;

@RestController
@RequestMapping("/api/v1/company")
public class CompanyController {
    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @PostMapping
    public ResponseEntity<Company> save(@RequestBody Company company) {
        Company c = companyService.save(company);

        return new ResponseEntity<>(c, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> findAll() {
        return new ResponseEntity<>(companyService.findAll(), HttpStatus.OK);    }
}
