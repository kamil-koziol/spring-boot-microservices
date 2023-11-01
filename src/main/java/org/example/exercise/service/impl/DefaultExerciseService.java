package org.example.exercise.service.impl;

import lombok.AllArgsConstructor;
import org.example.exercise.entity.Exercise;
import org.example.exercise.repository.api.ExerciseRepository;
import org.example.exercise.service.api.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class DefaultExerciseService implements ExerciseService {
    private final ExerciseRepository repository;

    @Autowired
    public DefaultExerciseService(ExerciseRepository repository) {
        this.repository = repository;
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
}
