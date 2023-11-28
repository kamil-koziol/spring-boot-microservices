package org.example.training.event.repository.rest;

import org.example.training.entity.Training;
import org.example.training.event.repository.api.TrainingEventRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Executable;
import java.util.UUID;

@Repository
public class TrainingEventRestRepository implements TrainingEventRepository {
    private final RestTemplate restTemplate;
    private static final Logger logger = LoggerFactory.getLogger(TrainingEventRepository.class);


    @Autowired
    public TrainingEventRestRepository(RestTemplate template) {
        this.restTemplate = template;
    }

    public void delete(UUID id) {
        try {
            restTemplate.delete("/api/trainings/{id}", id);
        } catch (RestClientException e) {
            logger.error(e.toString());
        }
    }

    @Override
    public void create(Training training) {
        try {
            restTemplate.put("/api/trainings/{id}", null, training.getId());
        } catch (RestClientException e) {
            logger.error(e.toString());
        }
    }
}
