package com.ligong.test.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@ControllerAdvice
public class GlobalExceptionControllerAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public void handlerMethodArgumentNotValidException(MethodArgumentNotValidException e){
        Map<String,String> map = new HashMap<>();
        List<FieldError> errors = e.getFieldErrors();
        errors.forEach(error->{
            log.error(error.getDefaultMessage());
        });

    }

}
