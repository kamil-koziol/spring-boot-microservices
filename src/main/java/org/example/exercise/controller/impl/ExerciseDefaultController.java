package org.example.exercise.controller.impl;

import org.example.exercise.controller.api.ExerciseController;
import org.example.exercise.dto.GetExerciseResponse;
import org.example.exercise.dto.GetExercisesResponse;
import org.example.exercise.dto.PatchExerciseRequest;
import org.example.exercise.dto.PutExerciseRequest;
import org.example.exercise.entity.Exercise;
import org.example.exercise.service.api.ExerciseService;
import org.example.training.entity.Training;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Optional;
import java.util.UUID;

@Controller
public class ExerciseDefaultController implements ExerciseController {

    private final ExerciseService service;

    @Autowired
    public ExerciseDefaultController(ExerciseService service) {
        this.service = service;
    }

    @Override
    public GetExerciseResponse getExercise(UUID id) {
        Optional<Exercise> exercise = service.findById(id);
        return GetExerciseResponse.fromExercise(exercise.get());
    }

    @Override
    public GetExercisesResponse getExercises() {
        return GetExercisesResponse.fromExercises(service.getAll());
    }

    @Override
    public void putExercise(UUID id, PutExerciseRequest request) {
        Exercise exercise = new Exercise().builder()
                .id(id)
                .name(request.getName())
                .description(request.getDescription())
                .bodyPart(request.getBodyPart())
                .training(Training.builder()
                        .id(request.getTraining())
                        .build())
                .difficulty(request.getDifficulty())
                .build();


        service.create(exercise);
    }

    @Override
    public void patchExercise(UUID id, PatchExerciseRequest request) {
        Exercise exercise = service.findById(id).get();
        exercise.setName(request.getName());
        exercise.setDifficulty(request.getDifficulty());
        exercise.setDescription(request.getDescription());
        service.create(exercise);
    }

    @Override
    public void deleteExercise(UUID id) {
        service.deleteById(id);
    }
}
