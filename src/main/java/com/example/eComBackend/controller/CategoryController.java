package com.example.eComBackend.controller;

import com.example.eComBackend.dto.CategoryResponse;
import com.example.eComBackend.entity.Category;
import com.example.eComBackend.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:5173/")
@AllArgsConstructor
@RestController
@RequestMapping("/category")
public class CategoryController {
    private CategoryService categoryService;

    @GetMapping
    public List<CategoryResponse> getAll(){
        List<CategoryResponse> cr = new ArrayList<>();
        for(Category c : categoryService.findAll()) {
            CategoryResponse response = new CategoryResponse(c.getId(), c.getCode(), c.getTitle(), c.getImage(), c.getRating(), c.getGender());
            cr.add(response);
        }
        return cr;
    }

    @GetMapping("/{categoryId}")
    public CategoryResponse getById(@PathVariable Long categoryId){
        Category c = categoryService.findById(categoryId);
        return new CategoryResponse(c.getId(), c.getCode(), c.getTitle(), c.getImage(), c.getRating(), c.getGender());
    }
}
