package com.bet.gateway.mapper;

import com.bet.gateway.dto.RouteDefinitionDto;
import com.bet.gateway.model.RouteDefinitionEntity;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
public interface RouteDefinitionMapper {
    RouteDefinitionDto toDto(RouteDefinitionEntity routeDefinitionEntity);
    RouteDefinitionEntity toEntity(RouteDefinitionDto routeDefinitionDto);
}
