package com.example.demo.service;

import com.example.demo.dto.ExerciseDto;
import com.example.demo.mapper.ExerciseMapper;
import com.example.demo.repository.ExerciseRepository;
import java.util.List;
import org.springframework.stereotype.Service;

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
        .orElseThrow(() -> new org.springframework.web.server.ResponseStatusException(
            org.springframework.http.HttpStatus.NOT_FOUND, "Exercise not found"));
  }

  public List<ExerciseDto> findByName(String name) {
    return repository.findByNameContainingIgnoreCase(name).stream()
        .map(mapper::toDto)
        .toList();
  }
}
