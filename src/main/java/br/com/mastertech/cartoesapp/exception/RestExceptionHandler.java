package br.com.mastertech.cartoesapp.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler {
    @ExceptionHandler(value = {SistemaCartoesException.class})
    protected ResponseEntity<Object> handleExceptions(SistemaCartoesException e) {
        return ResponseEntity.status(e.getHttpStatus()).body(e.getMessage());
    }
}