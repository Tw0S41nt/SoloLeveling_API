package com.sololeveling.solofit.service;

import com.sololeveling.solofit.dto.TemplateDto;
import com.sololeveling.solofit.dto.TemplateRequest;
import com.sololeveling.solofit.mapper.TemplateMapper;
import com.sololeveling.solofit.model.Exercise;
import com.sololeveling.solofit.model.Template;
import com.sololeveling.solofit.model.User;
import com.sololeveling.solofit.repository.ExerciseRepository;
import com.sololeveling.solofit.repository.TemplateRepository;
import com.sololeveling.solofit.repository.UserRepository;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

@Service
@Transactional(readOnly = true)
public class TemplateService {

  private final TemplateRepository repository;
  private final UserRepository userRepository;
  private final ExerciseRepository exerciseRepository;
  private final TemplateMapper mapper;

  public TemplateService(
      TemplateRepository repository,
      UserRepository userRepository,
      ExerciseRepository exerciseRepository,
      TemplateMapper mapper) {
    this.repository = repository;
    this.userRepository = userRepository;
    this.exerciseRepository = exerciseRepository;
    this.mapper = mapper;
  }

  public List<TemplateDto> findAll() {
    return repository.findAll().stream().map(mapper::toDto).toList();
  }

  public TemplateDto findById(Integer id) {
    return mapper.toDto(getTemplate(id));
  }

  public List<TemplateDto> findByDayOfWeek(String dayOfWeek) {
    return repository.findByDayOfWeekContainingIgnoreCase(dayOfWeek).stream()
        .map(mapper::toDto)
        .toList();
  }

  @Transactional
  public TemplateDto create(TemplateRequest request) {
    Template template = new Template();
    applyRequest(template, request);
    return mapper.toDto(repository.save(template));
  }

  @Transactional
  public TemplateDto update(Integer id, TemplateRequest request) {
    Template template = getTemplate(id);
    applyRequest(template, request);
    return mapper.toDto(repository.save(template));
  }

  /** Deletes the template; its template_exercises rows go with it, the exercises stay. */
  @Transactional
  public void delete(Integer id) {
    repository.delete(getTemplate(id));
  }

  private Template getTemplate(Integer id) {
    return repository
        .findById(id)
        .orElseThrow(() ->
            new ResponseStatusException(HttpStatus.NOT_FOUND, "Template " + id + " not found"));
  }

  /** Copies the request onto the template, checking that the user and exercises exist. */
  private void applyRequest(Template template, TemplateRequest request) {
    User user = userRepository
        .findById(request.userId())
        .orElseThrow(() -> new ResponseStatusException(
            HttpStatus.BAD_REQUEST, "User " + request.userId() + " not found"));

    Set<Integer> exerciseIds =
        request.exerciseIds() == null ? Set.of() : new HashSet<>(request.exerciseIds());
    List<Exercise> exercises = exerciseRepository.findAllById(exerciseIds);
    if (exercises.size() != exerciseIds.size()) {
      throw new ResponseStatusException(
          HttpStatus.BAD_REQUEST, "One or more exercise ids do not exist: " + exerciseIds);
    }

    template.setDayOfWeek(request.dayOfWeek());
    template.setUser(user);
    template.getExercises().clear();
    template.getExercises().addAll(exercises);
  }
}
