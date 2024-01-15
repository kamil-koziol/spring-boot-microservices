package org.example.exercise.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Singular;
import org.example.exercise.entity.Exercise;

import java.util.List;
import java.util.UUID;

@Data
@Builder
public class GetExercisesResponse {

    @Data
    @AllArgsConstructor
    public static class Exercise {
        UUID id;
        String name;

        UUID trainingId;
    }

    @Singular
    List<Exercise> exercises;

    public static GetExercisesResponse fromExercises(List<org.example.exercise.entity.Exercise> exercises) {
        var response = GetExercisesResponse.builder();

        var exercisesDto = exercises.stream().map(exercise -> {
            return response.exercise(new Exercise(exercise.getId(), exercise.getName(), exercise.getTraining().getId()));
        }).toList();

        return response.build();
    }
}
