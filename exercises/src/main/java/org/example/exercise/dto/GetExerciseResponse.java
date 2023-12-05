package org.example.exercise.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.example.exercise.entity.BodyPart;
import org.example.exercise.entity.Exercise;
import org.example.training.entity.Training;

import java.util.UUID;

@Data
@Builder
public class GetExerciseResponse {
    UUID id;
    String name;
    BodyPart bodyPart;
    int difficulty;
    String description;

    @Data
    @AllArgsConstructor
    public static class Training {
        private UUID id;
    }

    Training training;

    public static GetExerciseResponse fromExercise(Exercise exercise) {
        org.example.training.entity.Training training = exercise.getTraining();
        return GetExerciseResponse.builder()
                .id(exercise.getId())
                .name(exercise.getName())
                .bodyPart(exercise.getBodyPart())
                .difficulty(exercise.getDifficulty())
                .description(exercise.getDescription())
                .training(new Training(training.getId()))
                .build();
    }
}
