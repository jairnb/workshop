package com.workshop.productservice.service;

import com.workshop.productservice.dto.ProductListDTO;
import com.workshop.productservice.dto.ProductDTO;
import com.workshop.productservice.dto.ProductSaveDTO;

public interface IProductService {
    ProductDTO save(ProductSaveDTO p);

    ProductListDTO findAll();
}
