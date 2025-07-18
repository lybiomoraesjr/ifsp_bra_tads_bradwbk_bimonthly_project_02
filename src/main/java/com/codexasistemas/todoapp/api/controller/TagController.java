package com.codexasistemas.todoapp.api.controller;

import com.codexasistemas.todoapp.api.dto.tag.TagRequestDto;
import com.codexasistemas.todoapp.api.dto.tag.TagResponseDto;
import com.codexasistemas.todoapp.api.service.interfaces.TagService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/tags")
public class TagController {

    @Autowired
    private TagService tagService;

    @GetMapping
    public List<TagResponseDto> findAll(@RequestParam(required = true) Long userId) {
        return tagService.findByUserId(userId);
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

    @PutMapping("/{id}")
    public ResponseEntity<TagResponseDto> update(
            @PathVariable Long id,
            @Valid @RequestBody TagRequestDto tagRequest) {
        TagResponseDto updatedTag = tagService.update(id, tagRequest);
        return ResponseEntity.ok(updatedTag);
    }
} 