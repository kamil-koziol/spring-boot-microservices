package org.example.exercise.entity;

import lombok.*;
import org.example.training.entity.Training;

import java.io.Serializable;
import java.util.UUID;

@Builder
@Data
public class Exercise implements Comparable<Exercise>, Serializable {
    UUID id;
    String name;
    BodyPart bodyPart;
    int difficulty;
    String description;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    Training training;

    @Override
    public int compareTo(Exercise o) {
        return ((Exercise) o).getDifficulty() - getDifficulty();
    }
}
