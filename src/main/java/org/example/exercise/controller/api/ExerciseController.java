package org.example.exercise.controller.api;

import org.example.exercise.dto.GetExerciseResponse;
import org.example.exercise.dto.GetExercisesResponse;
import org.example.exercise.dto.PatchExerciseRequest;
import org.example.exercise.dto.PutExerciseRequest;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.UUID;

public interface ExerciseController {

    GetExerciseResponse getExercise(UUID id);
    GetExercisesResponse getExercises();
    void putExercise(UUID id, PutExerciseRequest request);
    void patchExercise(UUID id, PatchExerciseRequest request);
    void deleteExercise(UUID id);
}
