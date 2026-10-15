package com.example.demo.dto;

import java.util.List;

public record TemplateDto(
    Integer templateId, String dayOfWeek, Integer userId, List<ExerciseSummary> exercises) {

  /** Just enough of each exercise to show what the template contains. */
  public record ExerciseSummary(Integer exerciseId, String name) {}
}
