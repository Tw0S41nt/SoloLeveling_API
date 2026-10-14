package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int userId;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "goal", nullable = true, length = 50)
    private String goal;

    @Column(name = "chest", columnDefinition = "TINYINT")
    private int chest;

    @Column(name = "biceps", columnDefinition = "TINYINT")
    private int biceps;

    @Column(name = "traps", columnDefinition = "TINYINT")
    private int traps;

    @Column(name = "delts", columnDefinition = "TINYINT")
    private int delts;

    @Column(name = "back", columnDefinition = "TINYINT")
    private int back;

    @Column(name = "quads", columnDefinition = "TINYINT")
    private int quads;

    @Column(name = "glutes", columnDefinition = "TINYINT")
    private int glutes;

    @Column(name = "calves", columnDefinition = "TINYINT")
    private int calves;

    @Column(name = "hamstrings", columnDefinition = "TINYINT")
    private int hamstrings;
}
