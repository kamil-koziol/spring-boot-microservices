package org.example.exercise.service;

import lombok.AllArgsConstructor;
import org.example.DataStore;
import org.example.exercise.entity.Exercise;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@AllArgsConstructor
public class DefaultExerciseService implements ExerciseService {
    private final DataStore dataStore;
    @Override
    public Optional<Exercise> findById(UUID id) {
        return dataStore.getExercise(id);
    }

    @Override
    public List<Exercise> getAll() {
        return dataStore.getAllExercises();
    }

    @Override
    public void addExercise(Exercise exercise) {
        dataStore.addExercise(exercise);
    }
}
