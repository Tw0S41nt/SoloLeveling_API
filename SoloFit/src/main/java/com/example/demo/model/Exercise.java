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

  @Column(name = "body_part", length = 20)
  private String bodyPart;

  @Column(name = "primary_muscle", length = 20)
  private String primaryMuscle;

  @Column(name = "secondary_muscle", length = 20)
  private String secondaryMuscle;

  @ManyToMany(mappedBy = "exercises")
  private Set<Template> templates = new HashSet<>();

  public Exercise() {}

  public Integer getExerciseId() {
    return exerciseId;
  }

  public void setExerciseId(Integer exerciseId) {
    this.exerciseId = exerciseId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }

  public String getVideo() {
    return video;
  }

  public void setVideo(String video) {
    this.video = video;
  }

  public String getBodyPart() {
    return bodyPart;
  }

  public void setBodyPart(String bodyPart) {
    this.bodyPart = bodyPart;
  }

  public String getPrimaryMuscle() {
    return primaryMuscle;
  }

  public void setPrimaryMuscle(String primaryMuscle) {
    this.primaryMuscle = primaryMuscle;
  }

  public String getSecondaryMuscle() {
    return secondaryMuscle;
  }

  public void setSecondaryMuscle(String secondaryMuscle) {
    this.secondaryMuscle = secondaryMuscle;
  }

  public Set<Template> getTemplates() {
    return templates;
  }

  public void setTemplates(Set<Template> templates) {
    this.templates = templates;
  }
}
