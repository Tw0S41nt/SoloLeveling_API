package com.sololeveling.solofit.model;

import java.util.HashSet;
import java.util.Set;

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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "templates")
public class Template {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "template_id")
  private Integer templateId;

  @Column(name = "day_of_week", nullable = false, length = 12)
  private String dayOfWeek;

  // Many templates belong to one user (owning side of templates.user_id)
  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "user_id", nullable = false)
  private User user;

  // Read-only copy of the FK so the user id can be returned without loading the User
  @Column(name = "user_id", insertable = false, updatable = false)
  private Integer userId;

  // Owning side of the template_exercises join table
  @ManyToMany
  @JoinTable(
      name = "template_exercises",
      joinColumns = @JoinColumn(name = "template_id"),
      inverseJoinColumns = @JoinColumn(name = "exercise_id"))
  private Set<Exercise> exercises = new HashSet<>();
}
