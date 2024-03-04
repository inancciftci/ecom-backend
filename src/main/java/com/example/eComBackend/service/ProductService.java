package com.example.eComBackend.service;

import com.example.eComBackend.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();
    Product save(Product product);
    Product createProduct(Product product, Long storeId, Long categoryId);
    Product findById(Long id);
    void delete(Product product);
}
