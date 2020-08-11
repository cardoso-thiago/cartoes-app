package br.com.mastertech.cartoesapp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;

public class CardActivationRequest {
    @NotNull(message = "O estado do cartão não pode ser nulo.")
    @JsonProperty("ativo")
    private Boolean active;

    public CardActivationRequest() {
    }

    public CardActivationRequest(Boolean active) {
        this.active = active;
    }

    public Boolean isAtivo() {
        return active;
    }
}
