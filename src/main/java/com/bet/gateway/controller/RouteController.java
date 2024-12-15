package com.bet.gateway.controller;

import com.bet.gateway.dto.RouteDefinitionDto;
import com.bet.gateway.service.RouteDefinitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/route")
public class RouteController {
    @Autowired
    RouteDefinitionService routeDefinitionService;
    @PostMapping("/add")
    public Mono<RouteDefinitionDto> add(@RequestBody RouteDefinitionDto routeDefinitionDto){
        return routeDefinitionService.addRoute(routeDefinitionDto);
    }

    @GetMapping("/get/active")
    public Flux<RouteDefinitionDto> getActiveRoute(){
        return routeDefinitionService.getActiveRoute();
    }
}
