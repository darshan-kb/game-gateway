package com.bet.gateway.service.impl;

import com.bet.gateway.dto.PassthroughURLDto;
import com.bet.gateway.mapper.PassthroughURLMapper;
import com.bet.gateway.model.PassthroughURL;
import com.bet.gateway.repository.PassthroughURLRepository;
import com.bet.gateway.service.PassthroughURLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class PassthroughURLServiceImpl implements PassthroughURLService {
    @Autowired
    PassthroughURLRepository passthroughURLRepository;
    @Autowired
    PassthroughURLMapper passthroughURLMapper;
    @Override
    public Mono<PassthroughURLDto> add(PassthroughURLDto passthroughURLDto){
//        PassthroughURL passthroughURL = passthroughURLMapper.toEntity(passthroughURLDto);
//        System.out.println("Hello");
        return passthroughURLRepository.save(passthroughURLMapper.toEntity(passthroughURLDto)).map(e ->  passthroughURLMapper.toDto(e));
    }

    @Override
    public Mono<PassthroughURL> getByRouteIdAndRequestUrl(String routeId, String requestUrl) {
        return passthroughURLRepository.findByRouteIdAndRequestUrl(routeId, requestUrl);
    }
}
