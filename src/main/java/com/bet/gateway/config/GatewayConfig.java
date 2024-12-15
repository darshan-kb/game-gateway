package com.bet.gateway.config;

import com.bet.gateway.model.RouteDefinitionEntity;
import com.bet.gateway.repository.RouteDefinitionMongoRepository;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.RouteDefinitionWriter;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component("gatewayConfig")
@Slf4j
public class GatewayConfig {
    @PostConstruct
    public void init(){
        loadRoutesinMemory().subscribe();
    }
    @Autowired
    RouteDefinitionMongoRepository routeDefinitionMongoRepository;
    @Autowired
    RouteDefinitionWriter routeDefinitionWriter;

    public Mono<Void> loadRoutesinMemory(){
        Flux<RouteDefinitionEntity> routeToBeLoaded = routeDefinitionMongoRepository.findAllByActive(true);

        return routeToBeLoaded.flatMap(
                route -> {
//                    log.info("Loading Active Routes with Route Id: {}",route.getRouteId());
                    System.out.println(route.getRouteId()+" "+route.getPredicates());
                    return routeDefinitionWriter.save(RouteDefinitionEntity.getRouteDefinition(route));
                }
        ).onErrorResume(
                ex -> Mono.error(new IllegalStateException())
        ).then();
    }
}
