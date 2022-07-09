package com.workshop.productservice.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductSaveDTO {
    @NotBlank(message = "Name cannot be empty")
    private String name;
    private String code;
    private double purchasePrice;
    private double salePrice;
}
