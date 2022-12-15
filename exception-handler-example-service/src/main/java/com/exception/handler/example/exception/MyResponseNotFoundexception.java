package com.exception.handler.example.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/*
This resolver was also instroduced in Spring 3.0 and is enabled in the DispatcherServlet .
Its main responsibility is to use the @ResponseStatus annotation available on custom exceptions and to map these
exceptions th Http status code.
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class MyResponseNotFoundexception extends RuntimeException {

    public MyResponseNotFoundexception(){
        super();
    }

    public MyResponseNotFoundexception(String message, Throwable throwable){
        super(message, throwable);
    }

    public MyResponseNotFoundexception(String message){
        super(message);
    }

    public MyResponseNotFoundexception(Throwable throwable){
        super(throwable);
    }

}
