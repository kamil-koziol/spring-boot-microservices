package org.example.training.controller.impl;

import org.example.training.controller.api.TrainingController;
import org.example.training.dto.*;
import org.example.training.entity.Training;
import org.example.training.service.api.TrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.UUID;

@Controller
public class TrainingDefaultController implements TrainingController {

    private final TrainingService service;

    @Autowired
    public TrainingDefaultController(TrainingService service) {
        this.service = service;
    }

    @Override
    public GetTrainingResponse getTraining(UUID id) {
        return GetTrainingResponse.fromTraining(service.findById(id).get());
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
        var training = service.findById(id).get();
        training.setName(request.getName());
        service.create(training);
    }

    @Override
    public void deleteTraining(UUID id) {
        service.deleteById(id);
    }
}
