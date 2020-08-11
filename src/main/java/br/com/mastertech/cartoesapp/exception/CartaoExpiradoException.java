package br.com.mastertech.cartoesapp.exception;

import org.springframework.http.HttpStatus;

public class CartaoExpiradoException extends SistemaCartoesException {
    public CartaoExpiradoException(String message) {
        super(message, HttpStatus.FORBIDDEN);
    }
}
