package com.productservice.repository;

import com.productservice.enity.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product,Integer> {
    List<Product> findByNameAndColor(String name, String color);
}
