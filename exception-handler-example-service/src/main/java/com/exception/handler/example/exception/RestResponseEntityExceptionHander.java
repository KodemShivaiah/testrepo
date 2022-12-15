package com.exception.handler.example.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
public class RestResponseEntityExceptionHander extends ResponseEntityExceptionHandler {
/*
    @ControllerAdvice
    Spring 3.2 brings support for a global @ExceptionHandler with the @ControllerAdvice annotation.
    This enables a mechanism that breaks away from the older MVC model and makes use of ResponseEntity along with
    the type safety and flexibility of @ExcpetionHandler
 */
    @ExceptionHandler(value = {
            IllegalArgumentException.class,
            IllegalStateException.class
    })
    protected ResponseEntity<Object> hadlerConflict(RuntimeException ex, WebRequest request){
        String bodyOfResponse = "This should be application specific";
        return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.CONFLICT, request);
    }
/*
    The @ControllerAdvice annotation allows us to consolidate our multiple, scattered @ExceptionHandlers from
    before into a single, global error handling component.
    The actual mechanism is extremely simple but also very flexible.
    -> It gives us full control over the body of the response as well as the status code.
    -> It provides mapping of several exceptions to the same method, to be handled together.
    -> It makes good use of the newer RESTful ResponseEntity response.
    One thing to keep in mind here is to match the exceptions declared with @ExceptionHandler to the exception
    used as the argument of the method.
    If these don't match, the compiler will not complain - no reason it should - and Spring will not complain either.
    However, when the exception is actually thrown at runtime, the exception resolving mechanism will fail with
    {java.lang.IllegalStateException: No suitable resolver for argument [0] [type=...]}
    HandlerMethod details......
 */

}
