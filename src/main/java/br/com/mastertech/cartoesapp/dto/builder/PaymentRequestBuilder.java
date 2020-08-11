package br.com.mastertech.cartoesapp.dto.builder;

import br.com.mastertech.cartoesapp.dto.PaymentRequest;

public final class PaymentRequestBuilder {
    private Long id;
    private String description;
    private double value;
    private Long cardId;

    private PaymentRequestBuilder() {
    }

    public static PaymentRequestBuilder aPaymentRequest() {
        return new PaymentRequestBuilder();
    }

    public PaymentRequestBuilder id(Long id) {
        this.id = id;
        return this;
    }

    public PaymentRequestBuilder description(String description) {
        this.description = description;
        return this;
    }

    public PaymentRequestBuilder value(double value) {
        this.value = value;
        return this;
    }

    public PaymentRequestBuilder cardId(Long cardId) {
        this.cardId = cardId;
        return this;
    }

    public PaymentRequest build() {
        return new PaymentRequest(id, description, value, cardId);
    }
}
