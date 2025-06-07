package com.codexasistemas.todoapp.api.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codexasistemas.todoapp.api.model.Tag;

public interface TagJpaRepository extends JpaRepository<Tag, Long> {
    
}
