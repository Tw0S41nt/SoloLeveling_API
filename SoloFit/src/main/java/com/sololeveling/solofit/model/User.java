package com.sololeveling.solofit.model;

import jakarta.persistence.*;
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

    @Column(name = "goal", nullable = true, length = 50)
    private String goal;

    @Column(name = "chest", columnDefinition = "TINYINT")
    private Integer chest;

    @Column(name = "biceps", columnDefinition = "TINYINT")
    private Integer biceps;

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
