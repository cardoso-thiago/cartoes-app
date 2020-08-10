package br.com.mastertech.cartoesapp.model.builder;

import br.com.mastertech.cartoesapp.model.Error;

import java.time.LocalDateTime;
import java.util.List;

public final class ErrorBuilder {
    private List<String> messages;
    private LocalDateTime timestamp;

    private ErrorBuilder() {
    }

    public static ErrorBuilder anError() {
        return new ErrorBuilder();
    }

    public ErrorBuilder messages(List<String> messages) {
        this.messages = messages;
        return this;
    }

    public ErrorBuilder timestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    public Error build() {
        return new Error(messages, timestamp);
    }
}
