package br.com.mastertech.cartoesapp.exception;

import org.springframework.http.HttpStatus;

public class ExpiredCardException extends CardSystemException {
    public ExpiredCardException(String message) {
        super(message, HttpStatus.FORBIDDEN);
    }
}
