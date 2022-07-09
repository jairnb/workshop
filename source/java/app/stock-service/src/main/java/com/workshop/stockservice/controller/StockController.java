package com.workshop.stockservice.controller;

import com.workshop.stockservice.dto.StockSaveDTO;
import com.workshop.stockservice.service.IStockService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/stocks")
@AllArgsConstructor
public class StockController {

    private final IStockService stockService;

    @PostMapping
    public ResponseEntity<?> save(@Valid @RequestBody StockSaveDTO s){
        stockService.save(s);
        return ResponseEntity.ok("Success");
    }

    @GetMapping
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok().body(stockService.findAll());
    }

}
