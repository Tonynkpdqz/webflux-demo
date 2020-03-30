package com.nkpdqz.webfluxdemo.controller;

import com.nkpdqz.webfluxdemo.Service.UserService;
import com.nkpdqz.webfluxdemo.Valid.APIException;
import com.nkpdqz.webfluxdemo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.CoreSubscriber;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/")
public class HelloController {

    @Autowired
    UserService service;

    @GetMapping("mono")
    public Mono<String> hello(){
        return Mono.just("hello webflux!");
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

    @GetMapping("testNotValid")
    public User testValidExceptionHandler(@Valid User user){
        return user;
    }

    @GetMapping("testControllerAdvice")
    public User testControllerAdvice(String name){
        return new User(11L,name,"123123123","nl@163.com");
    }

    @GetMapping("testStringAdvice")
    public String testStringAdvice(){
        return "hello!";
    }

    @GetMapping("testNullAdvice")
    public String testNullAdvice() throws Exception {
        throw new APIException("test error.");
    }
}
