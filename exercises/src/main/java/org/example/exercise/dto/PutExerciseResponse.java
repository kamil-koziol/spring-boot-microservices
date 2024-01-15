package org.example.exercise.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.example.exercise.entity.Exercise;

import java.util.List;
import java.util.UUID;

@Data
@Builder
public class PutExerciseResponse {


    UUID id;

    public static PutExerciseResponse fromExercise(Exercise exercise) {
        var response = PutExerciseResponse.builder();
        response.id(exercise.getId());
        return response.build();
    }
}
