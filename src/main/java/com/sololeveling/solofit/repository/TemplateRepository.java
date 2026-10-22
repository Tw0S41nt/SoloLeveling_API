package com.sololeveling.solofit.repository;

import com.sololeveling.solofit.model.Template;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TemplateRepository extends JpaRepository<Template, Integer> {

  List<Template> findByDayOfWeekContainingIgnoreCase(String dayOfWeek);
}
