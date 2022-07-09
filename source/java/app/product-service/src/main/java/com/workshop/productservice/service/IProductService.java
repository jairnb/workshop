package com.workshop.productservice.service;

import com.workshop.productservice.dto.AllProductDTO;
import com.workshop.productservice.dto.ProductDTO;
import com.workshop.productservice.dto.ProductSaveDTO;

public interface IProductService {
    ProductDTO save(ProductSaveDTO p);

    AllProductDTO findAll();
}
