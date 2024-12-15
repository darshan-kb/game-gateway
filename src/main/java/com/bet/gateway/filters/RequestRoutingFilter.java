package com.bet.gateway.filters;

import com.bet.gateway.model.PassthroughURL;
import com.bet.gateway.service.PassthroughURLService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.ForwardRoutingFilter;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.support.ServerWebExchangeUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.DispatcherHandler;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.net.URISyntaxException;

@Component
@Slf4j
public class RequestRoutingFilter extends ForwardRoutingFilter {

    @Autowired
    PassthroughURLService passthroughURLService;

    public RequestRoutingFilter(ObjectProvider<DispatcherHandler> dispatcherHandlerProvider) {
        super(dispatcherHandlerProvider);
    }

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        Route r = (Route) exchange.getAttributes().get(ServerWebExchangeUtils.GATEWAY_ROUTE_ATTR);
        String path = exchange.getRequest().getPath().toString();
//        Mono<PassthroughURL> passthroughURL = passthroughURLService.getByRouteIdAndRequestUrl(r.getId(), path);
        String targetUri = r.getUri()+path;
//        System.out.println(r.getId()+" "+path);
        try {
            exchange.getAttributes().put(ServerWebExchangeUtils.GATEWAY_REQUEST_URL_ATTR, new URI(targetUri));
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
        return chain.filter(exchange);
//        System.out.println("No passthrough found for "+r.getId()+" "+path);
//        return passthroughURL
//                .switchIfEmpty(Mono.error(new IllegalStateException("No passthrough found for "+r.getId()+" "+path)))
//                .flatMap(url -> {
//            if(!url.isUseRewritePathAsApiUrl()){
//                String targetUri = url.getDomain()+url.getApiUrl();
//                try{
//                    exchange.getAttributes().put(ServerWebExchangeUtils.GATEWAY_REQUEST_URL_ATTR, new URI(targetUri));
//                }
//                catch(Exception ex){
////                    log.error("Error while parsing uri");
//                }
//            }
////            return Mono.just("success");
//            return chain.filter(exchange);
////
//        });
    }
}
