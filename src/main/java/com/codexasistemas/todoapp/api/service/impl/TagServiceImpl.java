package com.codexasistemas.todoapp.api.service.impl;

import com.codexasistemas.todoapp.api.model.Tag;
import com.codexasistemas.todoapp.api.repository.interfaces.TagRepository;
import com.codexasistemas.todoapp.api.service.interfaces.TagService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TagServiceImpl implements TagService {

    @Autowired
    private TagRepository tagRepository;

    @Override
    public Tag findById(Long id) {
        return tagRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Tag not found"));
    }
} 