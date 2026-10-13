package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.util.HashSet;
import java.util.Set;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "exercises")
@Getter
@Setter
@NoArgsConstructor
public class Exercise {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "exercise_id")
  private Integer exerciseId;

  @Column(name = "name", nullable = false, length = 50)
  private String name;

  @Column(name = "description", length = 1000)
  private String description;

  @Column(name = "image", length = 255)
  private String image;

  @Column(name = "video", length = 255)
  private String video;

  @Column(name = "body_part", length = 20)
  private String bodyPart;

  @Column(name = "primary_muscle", length = 20)
  private String primaryMuscle;

  @Column(name = "secondary_muscle", length = 20)
  private String secondaryMuscle;

  // Inverse side of the template_exercises join table (owned by Template)
  @ManyToMany(mappedBy = "exercises")
  private Set<Template> templates = new HashSet<>();
}
