package com.example.demo.dto;

import lombok.Data;
import lombok.Value;

@Data
@Value
public class UserDto {
    private int userId;
    private String name;
    private String goal;
    private int chest;
    private int biceps;
    private int traps;
    private int delts;
    private int back;
    private int quads;
    private int glutes;
    private int calves;
    private int hamstrings;
}
