package com.codexasistemas.todoapp.api.dto.location;

import jakarta.validation.constraints.NotNull;

public record LocationDto(
    @NotNull(message = "A latitude é obrigatória.")
    Double latitude,

    @NotNull(message = "A longitude é obrigatória.")
    Double longitude,

    String locationName,

    String locationDescription
) {} 