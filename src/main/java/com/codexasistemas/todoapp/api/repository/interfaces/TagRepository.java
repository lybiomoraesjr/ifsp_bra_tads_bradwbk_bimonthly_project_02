package com.codexasistemas.todoapp.api.repository.interfaces;

import com.codexasistemas.todoapp.api.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Long> {
} 