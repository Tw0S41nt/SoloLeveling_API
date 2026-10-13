package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "templates")
@Getter
@Setter
@NoArgsConstructor
public class Template {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "template_id")
  private Integer templateId;

  @Column(name = "day_of_week", nullable = false, length = 12)
  private String dayOfWeek;

  // Many templates belong to one user (owning side of the FK)
  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "user_id", nullable = false)
  private User user;

  // Owning side of the template_exercises join table
  @ManyToMany
  @JoinTable(
      name = "template_exercises",
      joinColumns = @JoinColumn(name = "template_id"),
      inverseJoinColumns = @JoinColumn(name = "exercise_id"))
  private Set<Exercise> exercises = new HashSet<>();
}
