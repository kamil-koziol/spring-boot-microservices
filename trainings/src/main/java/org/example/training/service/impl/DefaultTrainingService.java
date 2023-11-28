package org.example.training.service.impl;

import org.example.training.entity.Training;
import org.example.training.event.repository.api.TrainingEventRepository;
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
    private final TrainingEventRepository eventRepository;

    @Autowired
    public DefaultTrainingService(TrainingRepository repository, TrainingEventRepository trainingEventRepository) {
        this.repository = repository;
        this.eventRepository = trainingEventRepository;
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
        eventRepository.create(training);
    }

    @Override
    public void deleteById(UUID id) {
        repository.deleteById(id);
        eventRepository.delete(id);
    }
}
