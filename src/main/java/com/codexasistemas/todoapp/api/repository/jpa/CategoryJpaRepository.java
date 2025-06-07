package com.codexasistemas.todoapp.api.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codexasistemas.todoapp.api.model.Category;

public interface CategoryJpaRepository extends JpaRepository<Category, Long> {
    
}
