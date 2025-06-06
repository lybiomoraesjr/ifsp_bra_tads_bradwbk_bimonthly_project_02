package com.codexasistemas.todoapp.api.service.impl;

import com.codexasistemas.todoapp.api.model.Category;
import com.codexasistemas.todoapp.api.repository.interfaces.CategoryRepository;
import com.codexasistemas.todoapp.api.service.interfaces.CategoryService;

import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category findById(Long id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Category not found"));
    }
} 