package com.example.demo.repository;

import com.example.demo.model.Exercises;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExerciseRepository extends JpaRepository<Exercises, Integer> {

  List<Exercises> findByNameContainingIgnoreCase(String name);
}
