package com.project.eventapp.controllerAdvice;


import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorHandlerControllerAdvice {
    @ExceptionHandler({RuntimeException.class, UsernameNotFoundException.class})
    public String handle(){
        return "error";
    }
}
