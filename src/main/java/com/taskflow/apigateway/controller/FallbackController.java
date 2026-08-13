package com.taskflow.apigateway.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@RestController
public class FallbackController {
    @GetMapping("/fallback/task")
    public Mono<String> taskFallback(ServerWebExchange exchange){
       exchange.getResponse().setStatusCode(HttpStatus.SERVICE_UNAVAILABLE);
        return Mono.just(
                "{\"error\":\"Task Service is currently unavailable\"}"
        );
    }
}
