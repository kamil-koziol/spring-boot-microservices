package org.example.exercise.dto;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Builder
@Data
public class ExerciseDto {
    UUID id;
    String name;
    String training;
}
