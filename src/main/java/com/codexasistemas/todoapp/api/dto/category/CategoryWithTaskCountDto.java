package com.codexasistemas.todoapp.api.dto.category;

import java.time.LocalDateTime;

public record CategoryWithTaskCountDto(
    Long id,
    String name,
    int taskCount,
    boolean hasUnfinishedTasks,
    LocalDateTime lastTaskUpdate
) {} 