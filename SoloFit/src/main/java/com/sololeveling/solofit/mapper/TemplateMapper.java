package com.sololeveling.solofit.mapper;

import com.sololeveling.solofit.dto.TemplateDto;
import com.sololeveling.solofit.model.Exercise;
import com.sololeveling.solofit.model.Template;
import java.util.Comparator;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class TemplateMapper {

  public TemplateDto toDto(Template template) {
    List<TemplateDto.ExerciseSummary> exercises = template.getExercises().stream()
        .sorted(Comparator.comparing(Exercise::getExerciseId))
        .map(exercise ->
            new TemplateDto.ExerciseSummary(exercise.getExerciseId(), exercise.getName()))
        .toList();

    return new TemplateDto(
        template.getTemplateId(), template.getDayOfWeek(), template.getUserId(), exercises);
  }
}
