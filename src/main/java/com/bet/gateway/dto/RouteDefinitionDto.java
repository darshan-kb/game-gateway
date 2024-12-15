package com.bet.gateway.dto;

import lombok.Data;
import lombok.Getter;
import org.springframework.cloud.gateway.filter.FilterDefinition;
import org.springframework.cloud.gateway.handler.predicate.PredicateDefinition;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Data
public class RouteDefinitionDto extends BaseDto {
    private static final long serialVersionUId=2L;
    private String routeId;
    private List<PredicateDefinition> predicates = new ArrayList<>();
    private List<FilterDefinition> filters = new ArrayList<>();
    private String uri;
    private int order = 0;
    private Map<String, Object> metadata = new HashMap<>();
    private boolean active = true;

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
