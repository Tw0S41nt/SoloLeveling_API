package com.sololeveling.solofit.model;

<<<<<<< HEAD
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
=======
import jakarta.persistence.*;
>>>>>>> kamboj-homework-3
import lombok.Data;

@Entity
@Data
@Table(name = "users")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "user_id")
  private Integer userId;

  @Column(name = "name", nullable = false, length = 50)
  private String name;

  @Column(name = "goal", length = 50)
  private String goal;

  // Muscle-group flags are TINYINT (0/1) columns that may be NULL, so they use Integer
  @Column(name = "chest", columnDefinition = "TINYINT")
  private Integer chest;

  @Column(name = "biceps", columnDefinition = "TINYINT")
  private Integer biceps;

  @Column(name = "triceps", columnDefinition = "TINYINT")
  private Integer triceps;

  @Column(name = "traps", columnDefinition = "TINYINT")
  private Integer traps;

  @Column(name = "delts", columnDefinition = "TINYINT")
  private Integer delts;

  @Column(name = "back", columnDefinition = "TINYINT")
  private Integer back;

  @Column(name = "quads", columnDefinition = "TINYINT")
  private Integer quads;

  @Column(name = "glutes", columnDefinition = "TINYINT")
  private Integer glutes;

  @Column(name = "calves", columnDefinition = "TINYINT")
  private Integer calves;

  @Column(name = "hamstrings", columnDefinition = "TINYINT")
  private Integer hamstrings;
}
