package com.codexasistemas.todoapp.api.dto.tag;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TagRequestDto(
    @NotBlank(message = "O nome da tag é obrigatório.")
    String name,
    
    @NotNull(message = "O ID do usuário é obrigatório.")
    Long userId
) {} 