package br.com.mastertech.cartoesapp.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.LocalDateTime;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Error {
    private List<String> messages;
    private LocalDateTime timestamp;

    public Error(List<String> messages, LocalDateTime timestamp) {
        this.messages = messages;
        this.timestamp = timestamp;
    }

    public List<String> getMessages() {
        return messages;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}
