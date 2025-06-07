package com.codexasistemas.todoapp.api.dto.task;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public record TaskResponseDto(
    Long id,
    String title,
    String description,
    boolean done,
    String category,
    List<String> tags,
    LocalDateTime createdAt,
    LocalDate dueDate
) {}