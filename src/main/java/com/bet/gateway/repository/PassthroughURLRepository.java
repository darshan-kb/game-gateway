package com.bet.gateway.repository;

import com.bet.gateway.model.PassthroughURL;
import com.bet.gateway.model.RouteDefinitionEntity;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface PassthroughURLRepository extends ReactiveMongoRepository<PassthroughURL, String> {
    Mono<PassthroughURL> findByRouteIdAndRequestUrl(String routeId, String requestUrl);
}
