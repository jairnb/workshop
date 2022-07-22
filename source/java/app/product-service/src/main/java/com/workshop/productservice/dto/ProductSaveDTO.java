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
public class ProductSaveDTO {
    @NotBlank(message = "Name cannot be empty")
    private String name;
    private String code;
    private double purchasedPrice;
    private double salePrice;
//    @NotBlank(message = "Company Id cannot be empty")
    private UUID companyId;
}
