package com.example.assignment.service;

import com.example.assignment.entity.Product;
import com.example.assignment.exception.NotExistException;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {
    List<Product> findAll(Pageable pageable);

    Product save(Product product);

    Product update(Product product) throws NotExistException;

    void delete(Integer id) throws NotExistException;

    Product findById(Integer id) throws NotExistException;

    Integer countPage(Pageable pageable);
}
