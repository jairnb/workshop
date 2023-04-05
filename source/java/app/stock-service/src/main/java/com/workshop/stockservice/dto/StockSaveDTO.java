package com.workshop.stockservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StockSaveDTO {
    private int quantity;
    @NotBlank(message = "Product Id cannot be empty")
    private UUID productId;
    @NotBlank(message = "Company Id cannot be empty")
    private UUID companyId;

}
