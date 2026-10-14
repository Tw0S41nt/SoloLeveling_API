package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "templates")
public class Templates {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int template_id;

    @Column(nullable = false, length = 10)
    String day_of_week;

    @JoinColumn(name = "user_id", nullable = false)
    @ManyToOne
    User user;

    @ManyToMany
    @JoinTable(
            name = "template_exercise",
            joinColumns = @JoinColumn(name = "template_id"),
            inverseJoinColumns = @JoinColumn(name = "exercise_id")
    )
    private Set<Exercises> studentCourses = new HashSet<>();
}
