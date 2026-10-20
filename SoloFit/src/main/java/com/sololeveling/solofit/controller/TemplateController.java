package com.sololeveling.solofit.controller;

import com.sololeveling.solofit.dto.TemplateDto;
import com.sololeveling.solofit.service.TemplateService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
}
