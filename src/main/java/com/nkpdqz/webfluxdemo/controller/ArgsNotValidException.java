package com.nkpdqz.webfluxdemo.controller;

import com.nkpdqz.webfluxdemo.Valid.APIException;
import com.nkpdqz.webfluxdemo.controller.IdenticalCodeAndMsg;
import com.nkpdqz.webfluxdemo.controller.MyResponse;
import com.nkpdqz.webfluxdemo.pojo.User;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import reactor.core.publisher.Mono;

import java.util.List;

@RestControllerAdvice
public class ArgsNotValidException {

    @ExceptionHandler(value = {APIException.class})
    public MyResponse<String> APIExceptionHandler(APIException e){
        return new MyResponse<String>(IdenticalCodeAndMsg.MSG_FAILED,e.getMessage());
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public String MethodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e){
        List<ObjectError> allErrors = e.getBindingResult().getAllErrors();
        ObjectError objectError = allErrors.get(0);
        String defaultMessage = objectError.getDefaultMessage();
        return defaultMessage;
    }
}
