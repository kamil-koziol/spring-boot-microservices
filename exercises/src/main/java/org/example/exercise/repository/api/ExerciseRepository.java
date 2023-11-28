package org.example.exercise.repository.api;

import org.example.exercise.entity.Exercise;
import org.example.training.entity.Training;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ExerciseRepository extends JpaRepository<Exercise, UUID> {
    List<Exercise> findAllByTraining(Training training);
}
