package com.example.demo.model;

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

import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "exercises")
public class Exercises {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private int exercise_id;

    @Column(nullable = false, length = 50)
    String name;

    @Column(nullable = false, length = 1000)
    String description;

    @Column(name = "image",length = 255)
    String image;

    @Column(name = "video", length = 255)
    String video;

    @Column(name = "body_part", length = 20)
    String bodyPart;   //upper or lower body for filter

    @Column(name = "primary_muscle", length = 20)
    String primaryMuscle;

    @Column(name = "secondary_muscle", length = 20)
    String secondaryMuscle;

    // Inverse side of the template_exercises join table (owned by Templates)
    @ManyToMany(mappedBy = "exercises")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Templates> templates = new HashSet<>();
}
