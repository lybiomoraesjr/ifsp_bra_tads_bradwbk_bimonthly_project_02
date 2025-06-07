package com.codexasistemas.todoapp.api.mapper;

import com.codexasistemas.todoapp.api.dto.tag.TagRequestDto;
import com.codexasistemas.todoapp.api.dto.tag.TagResponseDto;
import com.codexasistemas.todoapp.api.model.Tag;

public class TagMapper {
    
    public static TagResponseDto toResponseDto(Tag tag) {
        return new TagResponseDto(
            tag.getId(),
            tag.getName()
        );
    }

    public static Tag toEntity(TagRequestDto dto) {
        Tag tag = new Tag();
        tag.setName(dto.name());
        return tag;
    }
} 