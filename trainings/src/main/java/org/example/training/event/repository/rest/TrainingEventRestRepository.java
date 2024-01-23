package org.example.training.event.repository.rest;

import org.example.training.entity.Training;
import org.example.training.event.repository.api.TrainingEventRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.cloud.client.discovery.DiscoveryClient;

import java.lang.reflect.Executable;
import java.util.NoSuchElementException;
import java.util.UUID;

@Repository
public class TrainingEventRestRepository implements TrainingEventRepository {
    private final RestTemplate restTemplate;
    private final LoadBalancerClient loadBalancerClient;
    private static final Logger logger = LoggerFactory.getLogger(TrainingEventRepository.class);


    @Autowired
    public TrainingEventRestRepository(RestTemplate template, LoadBalancerClient loadBalancerClient) {
        this.restTemplate = template;
        this.loadBalancerClient = loadBalancerClient;
    }

    public void delete(UUID id) {
        try {
            String uri = loadBalancerClient.choose("exercises").getUri().toString();

            logger.info("[DELETE] Eureka found exercise " + uri);

            restTemplate.delete(uri + "/api/trainings/{id}", id);
        } catch (RestClientException | NoSuchElementException e) {
            logger.error(e.toString());
        }
    }

    @Override
    public void create(Training training) {
        try {
            String uri = loadBalancerClient.choose("exercises").getUri().toString();
            logger.info("[CREATE] Eureka found exercise " + uri);
            restTemplate.put(uri + "/api/trainings/{id}", null, training.getId());
        } catch (RestClientException | NoSuchElementException e) {
            logger.error(e.toString());
        }
    }
}
