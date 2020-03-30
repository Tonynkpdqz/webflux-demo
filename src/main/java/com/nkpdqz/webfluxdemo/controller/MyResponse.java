package com.nkpdqz.webfluxdemo.controller;

public class MyResponse<T> {

    private Integer code;
    private String msg;
    private T data;

    public MyResponse(T data) {
        this(IdenticalCodeAndMsg.MSG_SUCCESS,data);
    }

    public MyResponse(IdenticalCodeAndMsg codeAndMsg, T data) {
        this.code = codeAndMsg.getCode();
        this.msg = codeAndMsg.getMsg();
        this.data = data;
    }

    @Override
    public String toString() {
        return "MyResponse{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
