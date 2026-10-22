package com.sololeveling.solofit.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.List;

/** Request body for creating (POST) or updating (PUT) a template. */
public record TemplateRequest(
    @NotBlank @Size(max = 12) String dayOfWeek,
    @NotNull Integer userId,
    List<Integer> exerciseIds) {}
