package com.nkpdqz.webfluxdemo.controller;

import lombok.extern.slf4j.Slf4j;
import org.reactivestreams.Subscription;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.publisher.MonoSink;

import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.stream.IntStream;

@RestController
@RequestMapping("/api2/")
@Slf4j
public class WebFluxController {

    final Logger log = LoggerFactory.getLogger(getClass());

    @GetMapping("mono")
    public Mono<Object> mono(){
        return Mono.create(new Consumer<MonoSink<Object>>() {
            @Override
            public void accept(MonoSink<Object> objectMonoSink) {
                log.info("创建Mono");
                objectMonoSink.success("hello webflux");
            }
        }).doOnSubscribe(new Consumer<Subscription>() {
            @Override
            public void accept(Subscription subscription) {
                log.info("{}",subscription);
            }
        }).doOnNext(new Consumer<Object>() {
            @Override
            public void accept(Object o) {
                log.info("{}",o);
            }
        });
    }

    @GetMapping("flux")
    public Flux<String> flux(){
        return Flux.just("hi!","webflux!","nkpdqz!");
    }

    //主动推送
    @GetMapping(value = "/SSE",produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<MyResponse<String>> SSEFlux(){
        return Flux.fromStream(IntStream.range(1,10).mapToObj(i ->{
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return new MyResponse<String>("flux send data--"+i);
        }));
    }

}
