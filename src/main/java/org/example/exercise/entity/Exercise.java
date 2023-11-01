package org.example.exercise.entity;

import jakarta.persistence.*;
import lombok.*;
import org.example.training.entity.Training;

import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
@Entity
@Builder
@Table(name = "exercises")

public class Exercise implements Comparable<Exercise>, Serializable {
    @Id
    UUID id;

    String name;
    BodyPart bodyPart;
    int difficulty;
    String description;

    @ManyToOne
    @JoinColumn(name = "training")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    Training training;

    @Override
    public int compareTo(Exercise o) {
        return ((Exercise) o).getDifficulty() - getDifficulty();
    }
}
