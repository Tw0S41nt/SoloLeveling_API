package com.sololeveling.solofit.mapper;

import com.sololeveling.solofit.dto.ExerciseDto;
import com.sololeveling.solofit.model.Exercise;
import org.springframework.stereotype.Component;

@Component
public class ExerciseMapper {

  public ExerciseDto toDto(Exercise exercise) {
    return new ExerciseDto(
        exercise.getExerciseId(),
        exercise.getName(),
        exercise.getDescription(),
        exercise.getImage(),
        exercise.getVideo(),
        exercise.getBodyPart(),
        exercise.getPrimaryMuscle(),
        exercise.getSecondaryMuscle());
  }
}
