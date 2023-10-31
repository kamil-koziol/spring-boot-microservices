package org.example.training.service;

import org.example.training.entity.Training;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TrainingService {
    public Optional<Training> findById(UUID id);
    public List<Training> getAll();
    public void addTraining(Training training);
}
