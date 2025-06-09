package com.codexasistemas.todoapp.api.repository.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.codexasistemas.todoapp.api.model.Category;
import com.codexasistemas.todoapp.api.repository.interfaces.CategoryRepository;
import com.codexasistemas.todoapp.api.repository.jpa.CategoryJpaRepository;

@Repository
public class CategoryRepositoryImpl implements CategoryRepository {

    private final CategoryJpaRepository jpa;

    public CategoryRepositoryImpl(CategoryJpaRepository jpa) {
        this.jpa = jpa;
    }

    @Override
    public Category save(Category category) {
        return jpa.save(category);
    }

    @Override
    public Optional<Category> findById(Long id) {
        return jpa.findById(id);
    }

    @Override
    public List<Category> findAll() {
        return jpa.findAll();
    }

    @Override
    public void deleteById(Long id) {
        jpa.deleteById(id);
    }

    @Override
    public List<Category> findByUserId(Long userId) {
        return jpa.findByUserId(userId);
    }

}
