package com.codexasistemas.todoapp.api.repository.interfaces;

import java.util.List;
import java.util.Optional;

import com.codexasistemas.todoapp.api.model.Tag;

public interface TagRepository {

    public Tag save(Tag tag);

    public Optional<Tag> findById(Long id);

    public List<Tag> findAll();

    public void deleteById(Long id);
    
    public List<Tag> findByUserId(Long userId);
} 