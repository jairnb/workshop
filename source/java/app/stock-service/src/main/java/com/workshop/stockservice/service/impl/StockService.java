package com.workshop.stockservice.service.impl;

import com.workshop.stockservice.dto.StockDTO;
import com.workshop.stockservice.dto.StockListDTO;
import com.workshop.stockservice.dto.StockSaveDTO;
import com.workshop.stockservice.entity.Stock;
import com.workshop.stockservice.repository.IStockRepository;
import com.workshop.stockservice.service.IStockService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@AllArgsConstructor
public class StockService implements IStockService {

    private final IStockRepository stockRepository;
    private final ModelMapper modelMapper;

    @Override
    public StockDTO save(StockSaveDTO s) {
        var stock = modelMapper.map(s, Stock.class);
        stock.setDate(LocalDate.now());
        var r = stockRepository.save(stock);
        return modelMapper.map(r, StockDTO.class);
    }

    @Override
    public StockListDTO findAll() {
        var s = stockRepository.findAll();
        final var stock = s.stream().map(st -> modelMapper.map(st, StockDTO.class)).toList();
        StockListDTO stockListDTO = new StockListDTO(stock);
        return stockListDTO;
    }
}
