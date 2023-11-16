package org.example.exercise.dto;

import lombok.Builder;
import lombok.Data;
import org.example.exercise.entity.BodyPart;

import java.util.UUID;

@Builder
@Data
public class PatchExerciseRequest {
    String name;
    int difficulty;
    String description;
}