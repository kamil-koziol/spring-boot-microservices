package org.example.training.controller.impl;

import lombok.extern.java.Log;
import org.example.training.controller.api.TrainingController;
import org.example.training.dto.*;
import org.example.training.entity.Training;
import org.example.training.service.api.TrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@RestController
@Log
public class TrainingDefaultController implements TrainingController {

    private final TrainingService service;

    @Autowired
    public TrainingDefaultController(TrainingService service) {
        this.service = service;
    }

    @Override
    public GetTrainingResponse getTraining(UUID id) {
        Training training = service.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return GetTrainingResponse.fromTraining(training);
    }

    @Override
    public GetTrainingsResponse getTrainings() {
        return GetTrainingsResponse.fromTrainings(service.getAll());
    }

    @Override
    public void putTraining(UUID id, PutTrainingRequest request) {
        var training = Training.builder();

        training.id(id);
        training.name(request.getName());

        service.create(training.build());
    }

    @Override
    public void patchTraining(UUID id, PatchTrainingRequest request) {
        Training training = service.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        training.setName(request.getName());
        service.create(training);
    }

    @Override
    public void deleteTraining(UUID id) {
        service.deleteById(id);
    }
}
