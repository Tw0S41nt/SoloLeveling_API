package com.sololeveling.solofit.controller;

import com.sololeveling.solofit.dto.TemplateDto;
import com.sololeveling.solofit.dto.TemplateRequest;
import com.sololeveling.solofit.service.TemplateService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/templates")
public class TemplateController {

  private final TemplateService service;

  public TemplateController(TemplateService service) {
    this.service = service;
  }

  // GET /api/templates
  @GetMapping
  public List<TemplateDto> getAllTemplates() {
    return service.findAll();
  }

  // GET /api/templates/{id}
  @GetMapping("/{id}")
  public TemplateDto getTemplateById(@PathVariable Integer id) {
    return service.findById(id);
  }

  // GET /api/templates/search?day=Monday
  @GetMapping("/search")
  public List<TemplateDto> searchTemplatesByDay(@RequestParam String day) {
    return service.findByDayOfWeek(day);
  }

  // POST /api/templates
  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public TemplateDto createTemplate(@Valid @RequestBody TemplateRequest request) {
    return service.create(request);
  }

  // PUT /api/templates/{id}
  @PutMapping("/{id}")
  public TemplateDto updateTemplate(
      @PathVariable Integer id, @Valid @RequestBody TemplateRequest request) {
    return service.update(id, request);
  }
}
