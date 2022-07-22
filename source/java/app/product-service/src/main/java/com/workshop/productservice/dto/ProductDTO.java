package com.workshop.productservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductDTO {
    private UUID id;
    private String name;
    private String code;
    private double purchasedPrice;
    private double salePrice;
    private UUID companyId;

}
