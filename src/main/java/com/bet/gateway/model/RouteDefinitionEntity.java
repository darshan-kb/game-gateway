package com.bet.gateway.model;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.FilterDefinition;
import org.springframework.cloud.gateway.handler.predicate.PredicateDefinition;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@Slf4j
@Document(value = "route_defination")
public class RouteDefinitionEntity extends BaseModel {

    @Field("route_id")
    @NotBlank(message = "RouteId must not be blank/null")
    @Indexed(unique=true, name = "route_defid_index")
    private String routeId;

    private List<PredicateDefinition> predicates = new ArrayList<>();

    private List<FilterDefinition> filters = new ArrayList<>();

    private String uri;

    private int order=0;
    private Map<String, Object> metadata = new HashMap<>();

    private boolean active=true;

    public static Mono<RouteDefinition> getRouteDefinition(RouteDefinitionEntity routeDefinitionEntity){
        RouteDefinition routeDefinition = new RouteDefinition();
        routeDefinition.setFilters(routeDefinitionEntity.getFilters());
        routeDefinition.setId(routeDefinitionEntity.getRouteId());
        routeDefinition.setPredicates(routeDefinitionEntity.getPredicates());
        routeDefinition.setUri(URI.create(routeDefinitionEntity.getUri()));
        routeDefinition.setMetadata(routeDefinitionEntity.getMetadata());
        return Mono.just(routeDefinition);
    }

    public String getRouteId() {
        return routeId;
    }

    public void setRouteId(String routeId) {
        this.routeId = routeId;
    }

    public List<PredicateDefinition> getPredicates() {
        return predicates;
    }

    public void setPredicates(List<PredicateDefinition> predicates) {
        this.predicates = predicates;
    }

    public List<FilterDefinition> getFilters() {
        return filters;
    }

    public void setFilters(List<FilterDefinition> filters) {
        this.filters = filters;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public Map<String, Object> getMetadata() {
        return metadata;
    }

    public void setMetadata(Map<String, Object> metadata) {
        this.metadata = metadata;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
