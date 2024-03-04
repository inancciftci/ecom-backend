package com.example.eComBackend.service;

import com.example.eComBackend.entity.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();
    Category createCategory(Category category);
    Category findById(Long id);
    void delete(Category category);
}
