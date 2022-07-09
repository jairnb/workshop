package com.workshop.productservice.controller;

import com.workshop.productservice.dto.ProductSaveDTO;
import com.workshop.productservice.service.IProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/products")
@AllArgsConstructor
public class ProductController {
    private final IProductService productService;

    @PostMapping
    public ResponseEntity<?> save(@Valid @RequestBody ProductSaveDTO p){
        var a = productService.save(p);
        return ResponseEntity.ok("Success");
    }

    @GetMapping
    public ResponseEntity<?> findAll() {
        return  ResponseEntity.ok().body(productService.findAll());
    }
}
