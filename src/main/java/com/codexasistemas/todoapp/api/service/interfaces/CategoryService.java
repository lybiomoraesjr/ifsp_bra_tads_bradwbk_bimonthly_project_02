package com.codexasistemas.todoapp.api.service.interfaces;

import com.codexasistemas.todoapp.api.dto.category.CategoryRequestDto;
import com.codexasistemas.todoapp.api.dto.category.CategoryResponseDto;
import com.codexasistemas.todoapp.api.model.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    List<CategoryResponseDto> findAll();
    Optional<CategoryResponseDto> findById(Long id);
    CategoryResponseDto create(CategoryRequestDto categoryRequest);
    CategoryResponseDto update(Long id, CategoryRequestDto categoryRequest);
    CategoryResponseDto delete(Long id);
    Category findByIdEntity(Long id);
} 