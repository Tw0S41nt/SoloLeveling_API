package com.sololeveling.solofit.repository;

import com.sololeveling.solofit.model.Exercise;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExerciseRepository extends JpaRepository<Exercise, Integer> {

  List<Exercise> findByNameContainingIgnoreCase(String name);
}
