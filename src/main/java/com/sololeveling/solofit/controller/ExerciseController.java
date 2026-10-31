package com.sololeveling.solofit.controller;

import com.sololeveling.solofit.dto.ExerciseDto;
import com.sololeveling.solofit.service.ExerciseService;
import java.util.List;

import com.sololeveling.solofit.mapper.ExerciseMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/exercises")
public class ExerciseController {

  private final ExerciseService service;
  private final ExerciseMapper exerciseMapper;


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

  //  Get exercise by primary Muscle
  @GetMapping("/primaryMuscle")
  public ResponseEntity<List<ExerciseDto>> getExerciseByPrimaryMuscle(@RequestParam String primaryMuscle){
    List<ExerciseDto> exercises = service.getExerciseByPrimaryMuscle(primaryMuscle);
    return new ResponseEntity<>(exercises, HttpStatus.OK
    );
  }

  //  Get exercise by Secondary Muscle
  @GetMapping("/secondaryMuscle")
  public ResponseEntity<List<ExerciseDto>> getExerciseBySecondaryMuscle(@RequestParam String secondaryMuscle){
    List<ExerciseDto> exercises = service.getExerciseBySecondaryMuscle(secondaryMuscle);
    return new ResponseEntity<>(exercises, HttpStatus.OK
    );
  }

}
