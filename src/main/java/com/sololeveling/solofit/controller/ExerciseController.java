package com.sololeveling.solofit.controller;

import com.sololeveling.solofit.dto.ExerciseDto;
import com.sololeveling.solofit.service.ExerciseService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/exercises")
public class ExerciseController {

  private final ExerciseService service;

  public ExerciseController(ExerciseService service) {
    this.service = service;
  }

  @GetMapping
  public List<ExerciseDto> getAllExercises() {
    return service.findAll();
  }

  @GetMapping("/{id}")
  public ExerciseDto getExerciseById(@PathVariable Integer id) {
    return service.findById(id);
  }

  @GetMapping("/search")
  public List<ExerciseDto> searchExercises(@RequestParam String name) {
    return service.findByName(name);
  }
}
