package com.codexasistemas.todoapp.api.service.impl;

import com.codexasistemas.todoapp.api.dto.tag.TagRequestDto;
import com.codexasistemas.todoapp.api.dto.tag.TagResponseDto;
import com.codexasistemas.todoapp.api.mapper.TagMapper;
import com.codexasistemas.todoapp.api.model.Tag;
import com.codexasistemas.todoapp.api.model.User;
import com.codexasistemas.todoapp.api.repository.interfaces.TagRepository;
import com.codexasistemas.todoapp.api.service.interfaces.TagService;
import com.codexasistemas.todoapp.api.service.interfaces.UserService;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TagServiceImpl implements TagService {

    @Autowired
    private TagRepository tagRepository;

    @Autowired
    private UserService userService;

    @Override
    public List<TagResponseDto> findAll() {
        return tagRepository.findAll().stream()
                .map(TagMapper::toResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<TagResponseDto> findById(Long id) {
        return tagRepository.findById(id)
                .map(TagMapper::toResponseDto);
    }

    @Override
    public TagResponseDto create(TagRequestDto tagRequest) {
        User user = userService.findByIdEntity(tagRequest.userId());
        Tag tag = TagMapper.toEntity(tagRequest, user);
        Tag savedTag = tagRepository.save(tag);
        return TagMapper.toResponseDto(savedTag);
    }

    @Override
    public TagResponseDto delete(Long id) {
        Tag tag = tagRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Tag não encontrada: " + id));
        TagResponseDto responseDto = TagMapper.toResponseDto(tag);
        tagRepository.deleteById(tag.getId());
        return responseDto;
    }

    @Override
    public Tag findByIdEntity(Long id) {
        return tagRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Tag não encontrada: " + id));
    }

    @Override
    public TagResponseDto update(Long id, TagRequestDto tagRequest) {
        Tag existingTag = tagRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Tag não encontrada: " + id));

        User user = userService.findByIdEntity(tagRequest.userId());
        existingTag.setName(tagRequest.name());
        existingTag.setUser(user);
        Tag updatedTag = tagRepository.save(existingTag);
        return TagMapper.toResponseDto(updatedTag);
    }

    @Override
    public List<TagResponseDto> findByUserId(Long userId) {
        return tagRepository.findByUserId(userId).stream()
                .map(TagMapper::toResponseDto)
                .collect(Collectors.toList());
    }
} 