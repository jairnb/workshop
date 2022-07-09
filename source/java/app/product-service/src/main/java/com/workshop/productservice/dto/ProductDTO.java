package com.workshop.productservice.dto;

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
public class ProductDTO {
    private UUID id;
    @NotBlank(message = "m")
    private String name;
    private String code;
    private double purchasePrice;
    private double salePrice;
}
