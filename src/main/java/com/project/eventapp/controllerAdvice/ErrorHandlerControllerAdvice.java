package com.project.eventapp.controllerAdvice;


import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorHandlerControllerAdvice {
    @ExceptionHandler(RuntimeException.class)
    public String handle(){
        return "error";
    }
}
