package org.example.training.controller.api;

import org.example.training.dto.GetTrainingResponse;
import org.example.training.dto.GetTrainingsResponse;
import org.example.training.dto.PatchTrainingRequest;
import org.example.training.dto.PutTrainingRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

public interface TrainingController {
    @GetMapping("/api/trainings/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetTrainingResponse getTraining(@PathVariable("id") UUID id);

    @GetMapping("/api/trainings")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetTrainingsResponse getTrainings();

    @PutMapping("/api/trainings/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    void putTraining(
            @PathVariable("id") UUID id,
            @RequestBody PutTrainingRequest request
    );

    @PatchMapping("/api/trainings/{id}")
    @ResponseStatus(HttpStatus.OK)
    void patchTraining(
            @PathVariable("id") UUID id,
            @RequestBody PatchTrainingRequest request
    );

    @DeleteMapping("/api/trainings/{id}")
    @ResponseStatus(HttpStatus.OK)
    void deleteTraining(@PathVariable("id") UUID id);
}
