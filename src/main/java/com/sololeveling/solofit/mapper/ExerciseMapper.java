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

  public void updateEntity(ExerciseDto dto, Exercise exercise) {
    exercise.setName(dto.name());
    exercise.setDescription(dto.description());
    exercise.setImage(dto.image());
    exercise.setVideo(dto.video());
    exercise.setBodyPart(dto.bodyPart());
    exercise.setPrimaryMuscle(dto.primaryMuscle());
    exercise.setSecondaryMuscle(dto.secondaryMuscle());
  }
}
