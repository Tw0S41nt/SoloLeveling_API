package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "user_id")
  private Integer userId;

  @Column(name = "name", nullable = false, length = 50)
  private String name;

  @Column(name = "goal", length = 50)
  private String goal;

  // Muscle-group flags stored as TINYINT (0/1)
  @Column(name = "chest", columnDefinition = "TINYINT")
  private Boolean chest;

  @Column(name = "biceps", columnDefinition = "TINYINT")
  private Boolean biceps;

  @Column(name = "triceps", columnDefinition = "TINYINT")
  private Boolean triceps;

  @Column(name = "traps", columnDefinition = "TINYINT")
  private Boolean traps;

  @Column(name = "delts", columnDefinition = "TINYINT")
  private Boolean delts;

  @Column(name = "back", columnDefinition = "TINYINT")
  private Boolean back;

  @Column(name = "quads", columnDefinition = "TINYINT")
  private Boolean quads;

  @Column(name = "glutes", columnDefinition = "TINYINT")
  private Boolean glutes;

  @Column(name = "calves", columnDefinition = "TINYINT")
  private Boolean calves;

  @Column(name = "hamstrings", columnDefinition = "TINYINT")
  private Boolean hamstrings;

  // One user owns many templates (templates.user_id -> users.user_id)
  @OneToMany(mappedBy = "user")
  private List<Template> templates = new ArrayList<>();
}
