package com.codexasistemas.todoapp.api.repository.interfaces;

import com.codexasistemas.todoapp.api.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
} 