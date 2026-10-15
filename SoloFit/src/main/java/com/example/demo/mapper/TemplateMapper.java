package com.example.demo.mapper;

import com.example.demo.dto.TemplateDto;
import com.example.demo.model.Exercises;
import com.example.demo.model.Templates;
import java.util.Comparator;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class TemplateMapper {

  public TemplateDto toDto(Templates template) {
    List<TemplateDto.ExerciseSummary> exercises = template.getExercises().stream()
        .sorted(Comparator.comparingInt(Exercises::getExercise_id))
        .map(e -> new TemplateDto.ExerciseSummary(e.getExercise_id(), e.getName()))
        .toList();

    return new TemplateDto(
        template.getTemplateId(), template.getDayOfWeek(), template.getUserId(), exercises);
  }
}
