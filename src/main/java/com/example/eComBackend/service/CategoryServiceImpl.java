package com.example.eComBackend.service;

import com.example.eComBackend.entity.Category;
import com.example.eComBackend.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService{

    private final CategoryRepository categoryRepository;

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category findById(Long id) {
        Optional<Category> categoryOptional = categoryRepository.findById(id);
        return categoryOptional.orElseThrow(() -> new RuntimeException("Category with given id not found."));
    }

    @Override
    public void delete(Category category) {
        categoryRepository.delete(category);
    }
}
