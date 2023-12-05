package org.example.exercise.service.impl;

import org.example.exercise.entity.Exercise;
import org.example.exercise.repository.api.ExerciseRepository;
import org.example.exercise.service.api.ExerciseService;
import org.example.training.repository.api.TrainingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class DefaultExerciseService implements ExerciseService {
    private final ExerciseRepository repository;
    private final TrainingRepository trainingRepository;

    @Autowired
    public DefaultExerciseService(ExerciseRepository repository, TrainingRepository trainingRepository) {
        this.repository = repository;
        this.trainingRepository = trainingRepository;
    }
    @Override
    public Optional<Exercise> findById(UUID id) {
        return repository.findById(id);
    }

    @Override
    public List<Exercise> getAll() {
        return repository.findAll();
    }

    @Override
    public void create(Exercise exercise) {
        repository.save(exercise);
    }

    @Override
    public void deleteById(UUID uuid) {
        repository.deleteById(uuid);
    }

    @Override
    public Optional<List<Exercise>> findAllByTraining(UUID trainingId) {
        return trainingRepository.findById(trainingId)
                .map(repository::findAllByTraining);
    }
}
