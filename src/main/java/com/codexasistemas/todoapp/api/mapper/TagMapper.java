package com.codexasistemas.todoapp.api.mapper;

import com.codexasistemas.todoapp.api.dto.tag.TagRequestDto;
import com.codexasistemas.todoapp.api.dto.tag.TagResponseDto;
import com.codexasistemas.todoapp.api.model.Tag;
import com.codexasistemas.todoapp.api.model.User;

public class TagMapper {
    
    public static TagResponseDto toResponseDto(Tag tag) {
        return new TagResponseDto(
            tag.getId(),
            tag.getName()
        );
    }

    public static Tag toEntity(TagRequestDto dto, User user) {
        Tag tag = new Tag();
        tag.setName(dto.name());
        tag.setUser(user);
        return tag;
    }
} 