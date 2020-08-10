package br.com.mastertech.cartoesapp.exception;

import org.springframework.http.HttpStatus;

class SistemaCartoesException extends Exception {
    private HttpStatus httpStatus;

    SistemaCartoesException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }

    HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
