package com.bet.gateway.controller;

import com.bet.gateway.dto.PassthroughURLDto;
import com.bet.gateway.service.PassthroughURLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/passthrough")
public class PassthroughURLController {
    @Autowired
    private PassthroughURLService passthroughURLService;
    @PostMapping("/add")
    public Mono<PassthroughURLDto> add(@RequestBody PassthroughURLDto passthroughURLDto){
        return passthroughURLService.add(passthroughURLDto);
    }
}
