package com.workshop.productservice.repository;

import com.workshop.productservice.entity.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IProductRepository extends CrudRepository<Product, UUID> {
}
