package br.com.mastertech.cartoesapp.dto;

import br.com.mastertech.cartoesapp.dto.builder.PaymentRequestBuilder;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class PaymentRequest {
    private Long id;
    @NotNull(message = "A descrição do pagamento não pode ser nula.")
    @NotEmpty(message = "A descrição do pagamento não pode ser vazia.")
    @JsonProperty("descricao")
    private String description;
    @NotNull(message = "O valor da transação não pode ser nulo.")
    @DecimalMin(value = "0.01", message = "O valor da transação deve ser um número positivo.")
    @JsonProperty("valor")
    private double value;
    @NotNull(message = "O id do cartão não pode ser nulo.")
    @Min(value = 1, message = "O id do cartão deve ser um número positivo.")
    @JsonProperty("cartao_id")
    private Long cardId;

    public PaymentRequest(Long id, String description, double value, Long cardId) {
        this.id = id;
        this.description = description;
        this.value = value;
        this.cardId = cardId;
    }

    public static PaymentRequestBuilder builder() {
        return PaymentRequestBuilder.aPaymentRequest();
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public double getValue() {
        return value;
    }

    public Long getCardId() {
        return cardId;
    }
}
