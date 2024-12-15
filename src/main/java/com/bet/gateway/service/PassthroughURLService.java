package com.bet.gateway.service;

import com.bet.gateway.dto.PassthroughURLDto;
import com.bet.gateway.model.PassthroughURL;
import reactor.core.publisher.Mono;

public interface PassthroughURLService {
    public Mono<PassthroughURLDto> add(PassthroughURLDto passthroughURLDto);

    public Mono<PassthroughURL> getByRouteIdAndRequestUrl(String routeId, String requestUrl);
}
