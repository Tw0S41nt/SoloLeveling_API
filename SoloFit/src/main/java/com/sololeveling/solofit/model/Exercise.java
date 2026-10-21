package com.sololeveling.solofit.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@Entity
@Table(name = "exercises")
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

  // Upper or lower body, used for filtering
  @Column(name = "body_part", length = 20)
  private String bodyPart;

  @Column(name = "primary_muscle", length = 20)
  private String primaryMuscle;

  @Column(name = "secondary_muscle", length = 20)
  private String secondaryMuscle;

  // Inverse side of the template_exercises join table (owned by Template)
  @ManyToMany(mappedBy = "exercises")
  @ToString.Exclude
  @EqualsAndHashCode.Exclude
  private Set<Template> templates = new HashSet<>();
}
