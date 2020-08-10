package br.com.mastertech.cartoesapp.exception;

import org.springframework.http.HttpStatus;

public class CartaoAlreadyExistsException extends SistemaCartoesException {
    public CartaoAlreadyExistsException(String message) {
        super(message, HttpStatus.UNPROCESSABLE_ENTITY);
    }
}
