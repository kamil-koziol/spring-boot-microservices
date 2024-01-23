package org.example;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.gateway.support.ServerWebExchangeUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.net.URI;

@SpringBootApplication
@EnableDiscoveryClient
public class GatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }

    @Bean
    public RouteLocator routeLocator(
            RouteLocatorBuilder builder,
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
                        .uri("lb://trainings")
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
                        .uri("lb://exercises")
                )
                .build();
    }
}