package com.nkpdqz.webfluxdemo.controller_without_MyResponse;

import com.nkpdqz.webfluxdemo.controller.MyResponse;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

@RestController
@RequestMapping("/api3/")
public class PlainController {

    //主动推送
    @GetMapping(value = "/send",produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<String> SSEFlux(){
        return Flux.fromStream(IntStream.range(1,10).mapToObj(i ->{
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "flux send data--"+i;
        }));
    }
}
