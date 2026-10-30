package com.sololeveling.solofit.service;

import com.sololeveling.solofit.dto.ExerciseDto;
import com.sololeveling.solofit.mapper.ExerciseMapper;
import com.sololeveling.solofit.model.Exercise;
import com.sololeveling.solofit.repository.ExerciseRepository;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ExerciseService {

  private final ExerciseRepository repository;
  private final ExerciseMapper mapper;

  public ExerciseService(ExerciseRepository repository, ExerciseMapper mapper) {
    this.repository = repository;
    this.mapper = mapper;
  }

  public List<ExerciseDto> findAll() {
    return repository.findAll().stream().map(mapper::toDto).toList();
  }

  public ExerciseDto findById(Integer id) {
    return repository
        .findById(id)
        .map(mapper::toDto)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Exercise not found"));
  }

  public List<ExerciseDto> findByName(String name) {
    return repository.findByNameContainingIgnoreCase(name).stream()
        .map(mapper::toDto)
        .toList();
  }

  public ExerciseDto createExercise(ExerciseDto dto) {
    Exercise exercise = new Exercise();
    mapper.updateEntity(dto, exercise);

    Exercise savedExercise = repository.save(exercise);
    return mapper.toDto(savedExercise);
  }

  public ExerciseDto updateExercise(Integer id, ExerciseDto dto) {
    Exercise exercise = repository
        .findById(id)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Exercise not found"));

    mapper.updateEntity(dto, exercise);

    Exercise savedExercise = repository.save(exercise);
    return mapper.toDto(savedExercise);
  }
}
