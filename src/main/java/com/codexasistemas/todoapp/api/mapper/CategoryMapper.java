package com.codexasistemas.todoapp.api.mapper;

import com.codexasistemas.todoapp.api.dto.category.CategoryRequestDto;
import com.codexasistemas.todoapp.api.dto.category.CategoryResponseDto;
import com.codexasistemas.todoapp.api.model.Category;
import com.codexasistemas.todoapp.api.model.User;

public class CategoryMapper {
    
    public static CategoryResponseDto toResponseDto(Category category) {
        return new CategoryResponseDto(
            category.getId(),
            category.getName(),
            category.getUser() != null ? category.getUser().getId() : null
        );
    }

    public static Category toEntity(CategoryRequestDto dto, User user) {
        Category category = new Category();
        category.setName(dto.name());
        category.setUser(user);
        return category;
    }
} 