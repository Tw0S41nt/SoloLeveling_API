package com.example.demo.model;

import jakarta.persistence.*;
import lombok.RequiredArgsConstructor;


@Entity
@RequiredArgsConstructor
@Table(name = "users")
public class users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int user_id;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = true, length = 50)
    private String goal;

    @Column(columnDefinition = "TINYINT")
    private int chest;

    @Column(columnDefinition = "TINYINT")
    private int biceps;

    @Column(columnDefinition = "TINYINT")
    private int traps;

    @Column(columnDefinition = "TINYINT")
    private int delts;

    @Column(columnDefinition = "TINYINT")
    private int back;

    @Column(columnDefinition = "TINYINT")
    private int quads;

    @Column(columnDefinition = "TINYINT")
    private int glutes;

    @Column(columnDefinition = "TINYINT")
    private int calves;

    @Column(columnDefinition = "TINYINT")
    private int hamstrings;
}
