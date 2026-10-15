package com.example.demo.dto;

public record ExerciseDto(
    Integer exerciseId,
    String name,
    String description,
    String image,
    String video,
    String bodyPart,
    String primaryMuscle,
    String secondaryMuscle) {}
