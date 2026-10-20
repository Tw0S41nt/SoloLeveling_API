package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.HashSet;
import java.util.Set;
import lombok.Data;

@Entity
@Data
@Table(name = "templates")
public class Templates {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  int template_id;

  @Column(nullable = false, length = 10)
  String day_of_week;

  @JoinColumn(name = "user_id", nullable = false)
  @ManyToOne
  User user;

  @ManyToMany
  @JoinTable(
      name = "template_exercise",
      joinColumns = @JoinColumn(name = "template_id"),
      inverseJoinColumns = @JoinColumn(name = "exercise_id"))
  private Set<Exercise> studentCourses = new HashSet<>();
}
