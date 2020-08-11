package br.com.mastertech.cartoesapp.dto;

import br.com.mastertech.cartoesapp.dto.builder.CardRequestBuilder;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class CardRequest {
    private Long id;
    @NotNull(message = "O numero do cartao não pode ser nulo.")
    @NotEmpty(message = "O numero do cartao não pode ser vazio.")
    @JsonProperty("numero")
    private String number;
    @NotNull(message = "O id do cliente não pode ser nulo.")
    @Min(value = 1, message = "O id do cliente deve ser um número positivo.")
    @JsonProperty("clienteId")
    private Long customerId;
    @JsonProperty("ativo")
    private boolean active;

    public CardRequest(Long id, String number, Long customerId, boolean active) {
        this.id = id;
        this.number = number;
        this.customerId = customerId;
        this.active = active;
    }

    public static CardRequestBuilder builder() {
        return CardRequestBuilder.aCardRequest();
    }

    public Long getId() {
        return id;
    }

    public String getNumber() {
        return number;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public boolean isActive() {
        return active;
    }
}
