package com.codexasistemas.todoapp.api.dto.tag;

import java.util.List;

public record TagWithTaskCountDto(
    Long id,
    String name,
    int taskCount,
    List<Long> categoryIds
) {} 