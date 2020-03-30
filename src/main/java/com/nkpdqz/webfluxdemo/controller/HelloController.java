package com.nkpdqz.webfluxdemo.controller;

import com.nkpdqz.webfluxdemo.Service.UserService;
import com.nkpdqz.webfluxdemo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.CoreSubscriber;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/")
public class HelloController {

    @Autowired
    UserService service;

    @GetMapping("mono")
    public Mono<MyResponse<String>> hello(){
        return Mono.just(new MyResponse<String>("hello webflux!"));
    }

    @PostMapping("addUser")
    public Mono<MyResponse<Integer>> addUser(@Valid User user){
        int code = service.addUser(user);
        return Mono.just(new MyResponse<Integer>(code));
    }

    @GetMapping("getUserByName")
    public Mono<MyResponse<User>> getUserByName(String name){
        User user = service.getUserByName(name);
        return Mono.just(new MyResponse<User>(user));
    }

}
