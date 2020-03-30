package com.nkpdqz.webfluxdemo.controller;

public enum IdenticalCodeAndMsg {

    //失败原因多元，这里暂时就用这一种，后面会再加
    MSG_SUCCESS(200,"success!"),
    MSG_FAILED(1001,"failed!");

    private int code;
    private String msg;

    IdenticalCodeAndMsg(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
