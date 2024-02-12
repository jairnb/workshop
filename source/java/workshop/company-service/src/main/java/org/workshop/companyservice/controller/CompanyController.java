package org.workshop.companyservice.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.workshop.companyservice.dto.CompanyDTO;
import org.workshop.companyservice.dto.CompanyListDTO;
import org.workshop.companyservice.service.CompanyService;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/company")
public class CompanyController {
    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @PostMapping
    public ResponseEntity<CompanyDTO> save(@Valid @RequestBody CompanyDTO companyDTO) {
        return new ResponseEntity<>(companyService.save(companyDTO), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<CompanyListDTO> findAll() {
        CompanyListDTO all = companyService.findAll();
        return new ResponseEntity<>(all, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CompanyDTO> findById(@PathVariable UUID id){
        CompanyDTO companyDTO = companyService.findById(id);
        return (companyDTO != null) ? new ResponseEntity<>(companyDTO, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable UUID id, @Valid @RequestBody CompanyDTO companyDTO) {

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable UUID id) throws Exception {
        companyService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
