package org.example.training.controller.impl;

import lombok.extern.java.Log;
import org.example.training.controller.api.TrainingController;
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
    public void deleteTraining(UUID id) {
        service.deleteById(id);
    }

    @Override
    public void createTraining(UUID id) {
        if(!service.findById(id).isEmpty()) {
            return;
        }

        Training training = Training.builder().id(id).build();
        service.create(training);
    }
}
