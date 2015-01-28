package com.jacksai.cinema.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, Map<String, String>> handleValidationError(MethodArgumentNotValidException ex) {
        BindingResult result = ex.getBindingResult();
        List<FieldError> fieldErrors = result.getFieldErrors();
        Map<String,Map<String,String>> response = new HashMap<>();
        response.put("ValidationErrors", processFieldErrors(fieldErrors));
        return response;
    }

    private Map<String, String> processFieldErrors(List<FieldError> fieldErrors) {
        Map<String,String> errorMap = new HashMap<>();

        fieldErrors.forEach((error)->{
            String localizedErrorMessage = resolveErrorMessage(error);
            errorMap.put(error.getField(), localizedErrorMessage);
        });

        return errorMap;
    }

    private String resolveErrorMessage(FieldError error) {
        String message = error.getDefaultMessage();
        return message;
    }

}
