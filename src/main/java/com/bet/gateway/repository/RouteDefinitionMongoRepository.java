package com.bet.gateway.repository;

import com.bet.gateway.model.RouteDefinitionEntity;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface RouteDefinitionMongoRepository extends ReactiveMongoRepository<RouteDefinitionEntity, String> {
    public Mono<RouteDefinitionEntity> findByRouteId(String  routeId);
    public Flux<RouteDefinitionEntity> findAllByActive(boolean isActive);
//    public Mono<List<RouteDefinitionEntity>> findAll();
}
