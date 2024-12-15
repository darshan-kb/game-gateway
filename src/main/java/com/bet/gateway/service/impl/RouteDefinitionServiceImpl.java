package com.bet.gateway.service.impl;

import com.bet.gateway.dto.RouteDefinitionDto;
import com.bet.gateway.mapper.RouteDefinitionMapper;
import com.bet.gateway.repository.RouteDefinitionMongoRepository;
import com.bet.gateway.service.RouteDefinitionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
@Slf4j
public class RouteDefinitionServiceImpl implements RouteDefinitionService {
    @Autowired
    RouteDefinitionMongoRepository routeDefinitionMongoRepository;
    @Autowired
    RouteDefinitionMapper mapper;
    @Override
    public Mono<RouteDefinitionDto> addRoute(RouteDefinitionDto routeDefinitionDto){
//        log.info("Creating route with routeId : {}",routeDefinitionDto.getRouteId());
        return routeDefinitionMongoRepository.insert(mapper.toEntity(routeDefinitionDto))
                .map(entity -> mapper.toDto(entity));
    }

    @Override
    public Flux<RouteDefinitionDto> getActiveRoute() {
        return routeDefinitionMongoRepository.findAllByActive(true).map(e -> mapper.toDto(e));
    }
}
