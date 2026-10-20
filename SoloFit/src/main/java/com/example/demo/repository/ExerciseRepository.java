package com.example.demo.repository;

import com.example.demo.model.Exercise;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExerciseRepository extends JpaRepository<Exercise, Integer> {

  List<Exercise> findByNameContainingIgnoreCase(String name);
}
