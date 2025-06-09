package com.codexasistemas.todoapp.api.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codexasistemas.todoapp.api.model.Category;
import java.util.List;

public interface CategoryJpaRepository extends JpaRepository<Category, Long> {
    List<Category> findByUserId(Long userId);
}
