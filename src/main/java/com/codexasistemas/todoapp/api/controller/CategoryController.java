package com.codexasistemas.todoapp.api.controller;

import com.codexasistemas.todoapp.api.dto.category.CategoryRequestDto;
import com.codexasistemas.todoapp.api.dto.category.CategoryResponseDto;
import com.codexasistemas.todoapp.api.service.interfaces.CategoryService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public List<CategoryResponseDto> findAll() {
        return categoryService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponseDto> findById(@PathVariable Long id) {
        return categoryService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<CategoryResponseDto> create(@Valid @RequestBody CategoryRequestDto categoryRequest) {
        CategoryResponseDto dto = categoryService.create(categoryRequest);
        return ResponseEntity.created(URI.create("/categories/" + dto.id())).body(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CategoryResponseDto> delete(@PathVariable Long id) {
        CategoryResponseDto deletedCategory = categoryService.delete(id);
        return ResponseEntity.ok(deletedCategory);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryResponseDto> update(
            @PathVariable Long id,
            @Valid @RequestBody CategoryRequestDto categoryRequest) {
        CategoryResponseDto updatedCategory = categoryService.update(id, categoryRequest);
        return ResponseEntity.ok(updatedCategory);
    }
} 