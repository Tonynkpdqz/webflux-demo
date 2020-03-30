package com.nkpdqz.webfluxdemo.Valid;


import lombok.Getter;

@Getter
public class APIException extends RuntimeException {

    public APIException(String msg) {
        super(msg);
    }

    public APIException() {
    }
}
