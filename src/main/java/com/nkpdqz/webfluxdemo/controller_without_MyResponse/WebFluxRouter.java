package com.nkpdqz.webfluxdemo.controller_without_MyResponse;

import com.nkpdqz.webfluxdemo.Service.HelloHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class WebFluxRouter {

    public RouterFunction<ServerResponse> routeHello(HelloHandler helloHandler){
        return RouterFunctions.route(RequestPredicates.GET("/hello")
                .and(RequestPredicates.accept(MediaType.TEXT_PLAIN)),helloHandler::hello);
    }
}
