package org.example.training.controller.api;

import org.example.training.dto.*;

import java.util.UUID;

public interface TrainingController {
    GetTrainingResponse getTraining(UUID id);
    GetTrainingsResponse getTrainings();
    void putTraining(UUID id, PutTrainingRequest request);
    void patchTraining(UUID id, PatchTrainingRequest request);
    void deleteTraining(UUID id);
}
