package org.example.training.service.impl;

import lombok.AllArgsConstructor;
import org.example.training.entity.Training;
import org.example.training.repository.api.TrainingRepository;
import org.example.training.service.api.TrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class DefaultTrainingService implements TrainingService {

    private final TrainingRepository repository;

    @Autowired
    public DefaultTrainingService(TrainingRepository repository) {
        this.repository = repository;
    }
    @Override
    public Optional<Training> findById(UUID id) {
        return repository.findById(id);
    }

    @Override
    public List<Training> getAll() {
        return repository.findAll();
    }

    @Override
    public void create(Training training) {
        repository.save(training);
    }

    @Override
    public void deleteById(UUID id) {
        repository.deleteById(id);
    }
}
