package br.com.mastertech.cartoesapp.exception;

import org.springframework.http.HttpStatus;

public class DeactivatedCardException extends CardSystemException {
    public DeactivatedCardException(String message) {
        super(message, HttpStatus.FORBIDDEN);
    }
}
