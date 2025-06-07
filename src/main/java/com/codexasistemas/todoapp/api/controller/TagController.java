package com.codexasistemas.todoapp.api.controller;

import com.codexasistemas.todoapp.api.dto.tag.TagRequestDto;
import com.codexasistemas.todoapp.api.dto.tag.TagResponseDto;
import com.codexasistemas.todoapp.api.service.interfaces.TagService;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/tags")
public class TagController {

    private final TagService tagService;

    public TagController(TagService tagService) {
        this.tagService = tagService;
    }

    @GetMapping
    public List<TagResponseDto> findAll() {
        return tagService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TagResponseDto> findById(@PathVariable Long id) {
        return tagService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<TagResponseDto> create(@Valid @RequestBody TagRequestDto tagRequest) {
        TagResponseDto dto = tagService.create(tagRequest);
        return ResponseEntity.created(URI.create("/tags/" + dto.id())).body(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<TagResponseDto> delete(@PathVariable Long id) {
        TagResponseDto deletedTag = tagService.delete(id);
        return ResponseEntity.ok(deletedTag);
    }
} 