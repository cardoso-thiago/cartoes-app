package br.com.mastertech.cartoesapp.exception;

import org.springframework.http.HttpStatus;

public class CartaoDesativadoException extends SistemaCartoesException {
    public CartaoDesativadoException(String message) {
        super(message, HttpStatus.FORBIDDEN);
    }
}
