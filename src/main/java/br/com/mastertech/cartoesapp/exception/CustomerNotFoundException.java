package br.com.mastertech.cartoesapp.exception;

import org.springframework.http.HttpStatus;

public class CustomerNotFoundException extends CardSystemException {

    public CustomerNotFoundException(String message) {
        super(message, HttpStatus.NOT_FOUND);
    }
}
