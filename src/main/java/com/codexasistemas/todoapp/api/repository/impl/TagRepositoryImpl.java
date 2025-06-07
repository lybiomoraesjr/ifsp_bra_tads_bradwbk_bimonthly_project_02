package com.codexasistemas.todoapp.api.repository.impl;

import java.util.List;
import java.util.Optional;

import com.codexasistemas.todoapp.api.model.Tag;
import com.codexasistemas.todoapp.api.repository.interfaces.TagRepository;
import com.codexasistemas.todoapp.api.repository.jpa.TagJpaRepository;

public class TagRepositoryImpl implements TagRepository {

    private final TagJpaRepository jpa;

    public TagRepositoryImpl(TagJpaRepository jpa) {
        this.jpa = jpa;
    }

    @Override
    public Tag save(Tag tag) {
        return jpa.save(tag);
    }

    @Override
    public Optional<Tag> findById(Long id) {
        return jpa.findById(id);
    }

    @Override
    public List<Tag> findAll() {
        return jpa.findAll();
    }

    @Override
    public void deleteById(Long id) {
        jpa.deleteById(id);
    }
}
