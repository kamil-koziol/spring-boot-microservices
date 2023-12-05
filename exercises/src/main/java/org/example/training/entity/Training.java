package org.example.training.entity;

import jakarta.persistence.*;
import lombok.*;
import org.example.exercise.entity.Exercise;

import java.io.*;
import java.util.List;
import java.util.UUID;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
@Entity
@Builder
@Table(name = "trainings")
public class Training implements Serializable {
    @Id
    UUID id;

    @OneToMany(mappedBy = "training", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    List<Exercise> exercises;
}
