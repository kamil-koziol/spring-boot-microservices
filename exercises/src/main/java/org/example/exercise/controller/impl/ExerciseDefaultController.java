package org.example.exercise.controller.impl;

import lombok.extern.java.Log;
import org.example.exercise.controller.api.ExerciseController;
import org.example.exercise.dto.GetExerciseResponse;
import org.example.exercise.dto.GetExercisesResponse;
import org.example.exercise.dto.PatchExerciseRequest;
import org.example.exercise.dto.PutExerciseRequest;
import org.example.exercise.entity.BodyPart;
import org.example.exercise.entity.Exercise;
import org.example.exercise.service.api.ExerciseService;
import org.example.training.entity.Training;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;
import java.util.UUID;

@RestController
@Log
public class ExerciseDefaultController implements ExerciseController {

    private final ExerciseService service;

    @Autowired
    public ExerciseDefaultController(ExerciseService service) {
        this.service = service;
    }

    @Override
    public GetExerciseResponse getExercise(UUID id) {
        Exercise exercise = service.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return GetExerciseResponse.fromExercise(exercise);
    }

    @Override
    public GetExercisesResponse getExercises() {
        return GetExercisesResponse.fromExercises(service.getAll());
    }

    @Override
    public GetExercisesResponse getTrainingExercises(UUID trainingId) {
        return GetExercisesResponse.fromExercises(service.findAllByTraining(trainingId).get());
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
