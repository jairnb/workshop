package com.workshop.stockservice.controller;

import com.workshop.stockservice.dto.StockDTO;
import com.workshop.stockservice.dto.StockListDTO;
import com.workshop.stockservice.dto.StockSaveDTO;
import com.workshop.stockservice.service.IStockService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;

import javax.validation.Valid;

@RestController
@RequestMapping("/stocks")
@AllArgsConstructor
public class StockController {

    private final IStockService stockService;
    private WebClient.Builder webClientBuilder;

    @PostMapping
    public ResponseEntity<StockDTO> save(@Valid @RequestBody StockSaveDTO s){
        var res = stockService.save(s);
        return new ResponseEntity<StockDTO>(res, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<StockListDTO> findAll() {
//        var a = webClientBuilder.build().get().uri("http://localhost:8085/products").retrieve().bodyToMono(ProductListDTO.class).block();
        var res = stockService.findAll();
        return new ResponseEntity<StockListDTO>(res, HttpStatus.OK);
    }

}
