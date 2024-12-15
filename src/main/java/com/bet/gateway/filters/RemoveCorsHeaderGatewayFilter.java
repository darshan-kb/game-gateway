//package com.bet.gateway.filters;
//
//import org.springframework.cloud.gateway.filter.GatewayFilter;
//import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.server.reactive.ServerHttpRequest;
//import org.springframework.http.server.reactive.ServerHttpResponse;
//import org.springframework.stereotype.Component;
//import reactor.core.publisher.Mono;
//
//@Component
//class RemoveCorsHeadersGatewayFilterFactory extends AbstractGatewayFilterFactory<Object> {
//
//    @Override
//    public GatewayFilter apply(Object config) {
//        return (exchange, chain) -> {
//            return chain.filter(exchange).then(Mono.fromRunnable(() -> {
//                ServerHttpRequest response = exchange.getRequest();
//                response.getHeaders().remove(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN);
//                // Add any other headers you want to remove
//            }));
//        };
//    }
//}
//
