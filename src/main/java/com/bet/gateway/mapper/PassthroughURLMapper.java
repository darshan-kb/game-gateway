package com.bet.gateway.mapper;

import com.bet.gateway.dto.PassthroughURLDto;
import com.bet.gateway.model.PassthroughURL;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PassthroughURLMapper {
    PassthroughURLDto toDto(PassthroughURL passthroughURL);
    PassthroughURL toEntity(PassthroughURLDto passthroughURLDto);
}
