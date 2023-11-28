package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;


@SpringBootApplication
public class GatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }

    @Bean
    public RouteLocator routeLocator(
            RouteLocatorBuilder builder,
            @Value("${ziut.exercises.url}") String exercisesUrl,
            @Value("${ziut.trainings.url}") String trainingsUrl,
            @Value("${ziut.gateway.host}") String host
    ) {
        return builder
                .routes()
                .route("trainings", route -> route
                        .host(host)
                        .and()
                        .path(
                                "/api/trainings/{uuid}",
                                "/api/trainings"
                        )
                        .uri(trainingsUrl)
                )
                .route("exercises", route -> route
                        .host(host)
                        .and()
                        .path(
                                "/api/exercises",
                                "/api/exercises/**",
                                "/api/trainings/{uuid}/exercises",
                                "/api/trainings/{uuid}/exercises/**"
                        )
                        .uri(exercisesUrl)
                )
                .build();
    }
}