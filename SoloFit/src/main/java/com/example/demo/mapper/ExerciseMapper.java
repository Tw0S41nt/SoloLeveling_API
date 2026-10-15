package com.example.demo.mapper;

import com.example.demo.dto.ExerciseDto;
import com.example.demo.model.Exercises;
import org.springframework.stereotype.Component;

@Component
public class ExerciseMapper {

  public ExerciseDto toDto(Exercises exercise) {
    return new ExerciseDto(
        exercise.getExercise_id(),
        exercise.getName(),
        exercise.getDescription(),
        exercise.getImage(),
        exercise.getVideo(),
        exercise.getBodyPart(),
        exercise.getPrimaryMuscle(),
        exercise.getSecondaryMuscle());
  }
}
