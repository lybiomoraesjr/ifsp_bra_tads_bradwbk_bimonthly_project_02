package com.codexasistemas.todoapp.api.dto.task;

import java.util.List;

public record TaskResponseDto(
    Long id,
    String title,
    String description,
    boolean done,
    String category,
    List<String> tags
) {}