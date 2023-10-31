package org.example.training.entity;

import lombok.*;
import org.example.exercise.entity.Exercise;

import java.io.*;
import java.util.List;
import java.util.UUID;

@Builder
@Data
public class Training implements Serializable {
    UUID id;
    String name;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    List<Exercise> exercises;
}
