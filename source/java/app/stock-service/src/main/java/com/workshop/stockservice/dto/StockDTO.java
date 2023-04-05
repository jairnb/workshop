package com.workshop.stockservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StockDTO {
    private UUID id;
    private int quantity;
    private LocalDate date;
    private UUID companyId;
    private UUID productId;
}
