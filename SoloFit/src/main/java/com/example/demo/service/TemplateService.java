package com.example.demo.service;

import com.example.demo.dto.TemplateDto;
import com.example.demo.mapper.TemplateMapper;
import com.example.demo.repository.TemplateRepository;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

@Service
@Transactional(readOnly = true)
public class TemplateService {

  private final TemplateRepository repository;
  private final TemplateMapper mapper;

  public TemplateService(TemplateRepository repository, TemplateMapper mapper) {
    this.repository = repository;
    this.mapper = mapper;
  }

  public List<TemplateDto> findAll() {
    return repository.findAll().stream().map(mapper::toDto).toList();
  }

  public TemplateDto findById(Integer id) {
    return repository
        .findById(id)
        .map(mapper::toDto)
        .orElseThrow(() -> new ResponseStatusException(
            HttpStatus.NOT_FOUND, "Template " + id + " not found"));
  }

  public List<TemplateDto> findByDayOfWeek(String dayOfWeek) {
    return repository.findByDayOfWeekContainingIgnoreCase(dayOfWeek).stream()
        .map(mapper::toDto)
        .toList();
  }
}
