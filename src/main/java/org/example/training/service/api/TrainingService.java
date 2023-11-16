package org.example.training.service.api;

import org.example.training.entity.Training;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TrainingService {
    public Optional<Training> findById(UUID id);
    public List<Training> getAll();
    public void create(Training training);
    public void deleteById(UUID id);
}
