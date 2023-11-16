package org.example.exercise.controller.api;

import org.example.exercise.dto.GetExerciseResponse;
import org.example.exercise.dto.GetExercisesResponse;
import org.example.exercise.dto.PatchExerciseRequest;
import org.example.exercise.dto.PutExerciseRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

public interface ExerciseController {
    @GetMapping("/api/exercises/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetExerciseResponse getExercise(@PathVariable("id") UUID id);

    @GetMapping("/api/exercises")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetExercisesResponse getExercises();

    @PutMapping("/api/exercises/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    void putExercise(
            @PathVariable("id") UUID id,
            @RequestBody PutExerciseRequest request
    );

    @PatchMapping("/api/exercises/{id}")
    @ResponseStatus(HttpStatus.OK)
    void patchExercise(
            @PathVariable("id") UUID id,
            @RequestBody PatchExerciseRequest request
    );

    @DeleteMapping("/api/exercises/{id}")
    @ResponseStatus(HttpStatus.OK)
    void deleteExercise(@PathVariable("id") UUID id);
}
