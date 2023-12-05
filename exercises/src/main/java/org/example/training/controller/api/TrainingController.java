package org.example.training.controller.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

public interface TrainingController {
    @DeleteMapping("/api/trainings/{id}")
    @ResponseStatus(HttpStatus.OK)
    void deleteTraining(@PathVariable("id") UUID id);

    @PutMapping("/api/trainings/{id}")
    @ResponseStatus(HttpStatus.OK)
    void createTraining(@PathVariable("id") UUID id);
}
