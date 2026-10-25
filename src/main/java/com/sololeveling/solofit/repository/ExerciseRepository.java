package com.sololeveling.solofit.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.sololeveling.solofit.model.Exercise;

public interface ExerciseRepository extends JpaRepository<Exercise, Integer> {

  List<Exercise> findByNameContainingIgnoreCase(String name);
  List<Exercise> findByPrimaryMuscleContainingIgnoreCase(String primaryMuscle);
  List<Exercise> findBySecondaryMuscleContainingIgnoreCase(String primaryMuscle);
}
