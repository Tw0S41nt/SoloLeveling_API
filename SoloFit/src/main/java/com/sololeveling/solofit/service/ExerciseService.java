package com.sololeveling.solofit.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.sololeveling.solofit.dto.ExerciseDto;
import com.sololeveling.solofit.mapper.ExerciseMapper;
import com.sololeveling.solofit.repository.ExerciseRepository;

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
