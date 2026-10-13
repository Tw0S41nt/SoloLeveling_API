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

@Entity
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

  @Column(name = "chest")
  private Byte chest;

  @Column(name = "biceps")
  private Byte biceps;

  @Column(name = "triceps")
  private Byte triceps;

  @Column(name = "traps")
  private Byte traps;

  @Column(name = "delts")
  private Byte delts;

  @Column(name = "back")
  private Byte back;

  @Column(name = "quads")
  private Byte quads;

  @Column(name = "glutes")
  private Byte glutes;

  @Column(name = "calves")
  private Byte calves;

  @Column(name = "hamstrings")
  private Byte hamstrings;

  @OneToMany(mappedBy = "user")
  private List<Template> templates = new ArrayList<>();

  public User() {}

  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getGoal() {
    return goal;
  }

  public void setGoal(String goal) {
    this.goal = goal;
  }

  public Byte getChest() {
    return chest;
  }

  public void setChest(Byte chest) {
    this.chest = chest;
  }

  public Byte getBiceps() {
    return biceps;
  }

  public void setBiceps(Byte biceps) {
    this.biceps = biceps;
  }

  public Byte getTriceps() {
    return triceps;
  }

  public void setTriceps(Byte triceps) {
    this.triceps = triceps;
  }

  public Byte getTraps() {
    return traps;
  }

  public void setTraps(Byte traps) {
    this.traps = traps;
  }

  public Byte getDelts() {
    return delts;
  }

  public void setDelts(Byte delts) {
    this.delts = delts;
  }

  public Byte getBack() {
    return back;
  }

  public void setBack(Byte back) {
    this.back = back;
  }

  public Byte getQuads() {
    return quads;
  }

  public void setQuads(Byte quads) {
    this.quads = quads;
  }

  public Byte getGlutes() {
    return glutes;
  }

  public void setGlutes(Byte glutes) {
    this.glutes = glutes;
  }

  public Byte getCalves() {
    return calves;
  }

  public void setCalves(Byte calves) {
    this.calves = calves;
  }

  public Byte getHamstrings() {
    return hamstrings;
  }

  public void setHamstrings(Byte hamstrings) {
    this.hamstrings = hamstrings;
  }

  public List<Template> getTemplates() {
    return templates;
  }

  public void setTemplates(List<Template> templates) {
    this.templates = templates;
  }
}
