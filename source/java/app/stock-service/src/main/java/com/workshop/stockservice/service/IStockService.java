package com.workshop.stockservice.service;

import com.workshop.stockservice.dto.StockDTO;
import com.workshop.stockservice.dto.StockListDTO;
import com.workshop.stockservice.dto.StockSaveDTO;

public interface IStockService {
    StockDTO save(StockSaveDTO s);
    StockListDTO findAll();
}
