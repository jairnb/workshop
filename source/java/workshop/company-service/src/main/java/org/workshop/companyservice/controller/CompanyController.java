package org.workshop.companyservice.controller;

import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.workshop.companyservice.dto.CompanyList;
import org.workshop.companyservice.entity.Company;
import org.workshop.companyservice.service.CompanyService;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/company")
@CrossOrigin(origins = "http://localhost:4200")
public class CompanyController {
    private final CompanyService companyService;
    private final Logger logger = LoggerFactory.getLogger(CompanyController.class);

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @PostMapping
    public ResponseEntity<Company> save(@Valid @RequestBody Company company) {
        logger.info("CompanyController::save Entered");
        return new ResponseEntity<>(companyService.save(company), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<CompanyList> findAll() {
        logger.info("CompanyController::findAll Entered");
        CompanyList all = companyService.findAll();
        return new ResponseEntity<>(all, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Company> findById(@PathVariable UUID id){
        logger.info("CompanyController::findById Entered");
        Company company = companyService.findById(id);
        return (company != null) ? new ResponseEntity<>(company, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable UUID id, @Valid @RequestBody Company company) throws Exception {
        logger.info("CompanyController::update Entered");
        Company companyDTOResponse = companyService.update(id, company);
        return (companyDTOResponse != null) ? new ResponseEntity<>(companyDTOResponse, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable UUID id) throws Exception {
        logger.info("CompanyController::delete Entered");
        companyService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
