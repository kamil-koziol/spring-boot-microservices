package org.example.training.service;

import lombok.AllArgsConstructor;
import org.example.DataStore;
import org.example.training.entity.Training;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@AllArgsConstructor
public class DefaultTrainingService implements TrainingService {
    private final DataStore dataStore;
    @Override
    public Optional<Training> findById(UUID id) {
        return dataStore.getTraining(id);
    }

    @Override
    public List<Training> getAll() {
        return dataStore.getAllTrainings();
    }

    @Override
    public void addTraining(Training training) {
        dataStore.addTraining(training);
    }
}
