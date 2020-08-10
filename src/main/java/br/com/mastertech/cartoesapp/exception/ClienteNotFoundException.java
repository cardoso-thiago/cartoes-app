package br.com.mastertech.cartoesapp.exception;

import org.springframework.http.HttpStatus;

public class ClienteNotFoundException extends SistemaCartoesException {

    public ClienteNotFoundException(String message) {
        super(message, HttpStatus.NOT_FOUND);
    }
}
