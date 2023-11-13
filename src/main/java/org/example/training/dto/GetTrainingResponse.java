package org.example.training.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Singular;
import org.example.training.entity.Training;

import java.util.List;
import java.util.UUID;

@Data
@Builder
public class GetTrainingResponse {

    UUID id;
    String name;

    @Data
    @AllArgsConstructor
    public static class Exercise {
        UUID id;
        String name;
    }

    @Singular
    List<Exercise> exercises;

    public static GetTrainingResponse fromTraining(Training training) {
        var response = GetTrainingResponse.builder();

        response.id(training.getId());
        response.name(training.getName());

        training.getExercises().forEach(exercise -> {
            response.exercise(new Exercise(exercise.getId(), exercise.getName()));
        });

        return response.build();
    }
}
