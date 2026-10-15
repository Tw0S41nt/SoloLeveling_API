package com.example.demo.repository;

import com.example.demo.model.Templates;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TemplateRepository extends JpaRepository<Templates, Integer> {

  List<Templates> findByDayOfWeekContainingIgnoreCase(String dayOfWeek);
}
