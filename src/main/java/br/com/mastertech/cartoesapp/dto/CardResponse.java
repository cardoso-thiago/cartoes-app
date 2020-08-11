package br.com.mastertech.cartoesapp.dto;

import br.com.mastertech.cartoesapp.dto.builder.CardResponseBuilder;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class CardResponse {
    private Long id;
    @NotNull(message = "O numero do cartao não pode ser nulo.")
    @NotEmpty(message = "O numero do cartao não pode ser vazio.")
    @JsonProperty("numero")
    private String number;
    @NotNull(message = "O id do cliente não pode ser nulo.")
    @Min(value = 1, message = "O id do cliente deve ser um número positivo.")
    @JsonProperty("clienteId")
    private Long customerId;

    public CardResponse(Long id, String number, Long customerId, boolean ativo) {
        this.id = id;
        this.number = number;
        this.customerId = customerId;
    }

    public static CardResponseBuilder builder() {
        return CardResponseBuilder.aCardResponse();
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
}
