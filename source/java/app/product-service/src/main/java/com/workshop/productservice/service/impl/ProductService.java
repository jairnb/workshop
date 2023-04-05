package com.workshop.productservice.service.impl;

import com.workshop.productservice.dto.ProductListDTO;
import com.workshop.productservice.dto.ProductDTO;
import com.workshop.productservice.dto.ProductSaveDTO;
import com.workshop.productservice.entity.Product;
import com.workshop.productservice.repository.IProductRepository;
import com.workshop.productservice.service.IProductService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.stream.StreamSupport;

@Service
@AllArgsConstructor
public class ProductService implements IProductService {

    private final IProductRepository productRepository;
    private final ModelMapper modelMapper;

    @Override
    public ProductDTO save(ProductSaveDTO p) {
        var product = productRepository.save(modelMapper.map(p, Product.class));
        var r = modelMapper.map(product, ProductDTO.class);
        return r;
    }

    @Override
    public ProductListDTO findAll() {
         var r = StreamSupport.stream(productRepository.findAll().spliterator(), false)
                .map(p -> modelMapper.map(p, ProductDTO.class)).toList();

         ProductListDTO productListDTO = new ProductListDTO(r);

         return productListDTO;
    }
}
