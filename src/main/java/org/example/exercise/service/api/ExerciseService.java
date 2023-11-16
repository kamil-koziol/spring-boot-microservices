package org.example.exercise.service.api;

import org.example.exercise.entity.Exercise;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ExerciseService {
    public Optional<Exercise> findById(UUID id);
    public List<Exercise> getAll();
    public void create(Exercise exercise);
    public void deleteById(UUID uuid);
}
