package com.workshop.productservice.controller;

import com.workshop.productservice.dto.*;
import com.workshop.productservice.service.IProductService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final IProductService productService;
    private WebClient.Builder webClientBuilder;
    @Value("${workshop.services.company-service.name}")
    private String companyServiceName;
    @Value("${workshop.services.company-service.port}")
    private String companyServicePort;

    public ProductController(IProductService productService, WebClient.Builder webClientBuilder) {
        this.productService = productService;
        this.webClientBuilder = webClientBuilder;
    }

    @PostMapping
    public ResponseEntity<ProductDTO> save(@Valid @RequestBody ProductSaveDTO p){
//        var company = webClientBuilder.build().post()
//                .uri("http://" + companyServiceName + ":" + companyServicePort + "/companies")
//                .bodyValue(new CompanySaveDTO("Company 1"))
//                .retrieve()
//                .bodyToMono(CompanyDTO.class);

        p.setCompanyId(UUID.randomUUID());
        var a = productService.save(p);
        return new ResponseEntity<>(a, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<ProductListDTO> findAll() {
        return new ResponseEntity<>(productService.findAll(), HttpStatus.OK);
    }
}
