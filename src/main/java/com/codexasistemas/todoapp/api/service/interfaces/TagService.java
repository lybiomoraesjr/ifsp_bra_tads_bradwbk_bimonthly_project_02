package com.codexasistemas.todoapp.api.service.interfaces;

import com.codexasistemas.todoapp.api.dto.tag.TagRequestDto;
import com.codexasistemas.todoapp.api.dto.tag.TagResponseDto;
import com.codexasistemas.todoapp.api.model.Tag;

import java.util.List;
import java.util.Optional;

public interface TagService {
    List<TagResponseDto> findAll();
    Optional<TagResponseDto> findById(Long id);
    TagResponseDto create(TagRequestDto tagRequest);
    TagResponseDto update(Long id, TagRequestDto tagRequest);
    TagResponseDto delete(Long id);
    Tag findByIdEntity(Long id);
    List<TagResponseDto> findByUserId(Long userId);
} 