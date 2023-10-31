package org.example.exercise.service;

import org.example.exercise.entity.Exercise;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ExerciseService {
    public Optional<Exercise> findById(UUID id);
    public List<Exercise> getAll();
    public void addExercise(Exercise exercise);
}
