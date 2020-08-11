package br.com.mastertech.cartoesapp.exception;

import org.springframework.http.HttpStatus;

public class CardAlreadyExistsException extends CardSystemException {
    public CardAlreadyExistsException(String message) {
        super(message, HttpStatus.UNPROCESSABLE_ENTITY);
    }
}
