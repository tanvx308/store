package com.example.assignment.service.impl;

import com.example.assignment.common.Constant;
import com.example.assignment.entity.Product;
import com.example.assignment.exception.NotExistException;
import com.example.assignment.repo.ProductRepo;
import com.example.assignment.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepo productRepo;

    @Override
    public List<Product> findAll(Pageable pageable) {
        return productRepo.findAll(pageable).getContent();
    }

    @Override
    public Product save(Product product) {
        return productRepo.save(product);
    }

    @Override
    public Product update(Product product) throws NotExistException {
        if(!productRepo.existsById(product.getId())){
            throw new NotExistException(400, String.format("Product with id %d is not exist", product.getId()));
        }
        return productRepo.save(product);
    }

    @Override
    public void delete(Integer id) throws NotExistException {
        if(!productRepo.existsById(id)){
            throw new NotExistException(400, String.format("Product with id %d is not exist", id));
        }
        Product product = productRepo.findById(id).orElse(null);
        product.setAvailable(Constant.IN_ACTIVE);
        productRepo.save(product);
    }

    @Override
    public Product findById(Integer id) throws NotExistException {
        if(!productRepo.existsById(id)){
            throw new NotExistException(400, String.format("Product with id %d is not exist", id));
        }
        return productRepo.findById(id).orElse(null);
    }

    @Override
    public Integer countPage(Pageable pageable) {
        Page<Product> page = productRepo.findAll(pageable);
        return page.getTotalPages();
    }
}
