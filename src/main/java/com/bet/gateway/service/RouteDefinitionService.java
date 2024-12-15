package com.bet.gateway.service;

import com.bet.gateway.dto.RouteDefinitionDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface RouteDefinitionService {
    public Mono<RouteDefinitionDto> addRoute(RouteDefinitionDto routeDefinitionDto);
    public Flux<RouteDefinitionDto> getActiveRoute();
}
