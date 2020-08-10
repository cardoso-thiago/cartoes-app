package br.com.mastertech.cartoesapp.exception;

import org.springframework.http.HttpStatus;

public class CartaoNotFoundException extends SistemaCartoesException {
    public CartaoNotFoundException(String message) {
        super(message, HttpStatus.NOT_FOUND);
    }
}
