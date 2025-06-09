package com.codexasistemas.todoapp.api.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codexasistemas.todoapp.api.model.Tag;
import java.util.List;

public interface TagJpaRepository extends JpaRepository<Tag, Long> {
    List<Tag> findByUserId(Long userId);
}
