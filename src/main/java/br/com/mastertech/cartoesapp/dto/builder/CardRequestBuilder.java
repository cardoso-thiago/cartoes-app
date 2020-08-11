package br.com.mastertech.cartoesapp.dto.builder;

import br.com.mastertech.cartoesapp.dto.CardRequest;

public final class CardRequestBuilder {
    private Long id;
    private String number;
    private Long customerId;
    private boolean active;

    private CardRequestBuilder() {
    }

    public static CardRequestBuilder aCardRequest() {
        return new CardRequestBuilder();
    }

    public CardRequestBuilder id(Long id) {
        this.id = id;
        return this;
    }

    public CardRequestBuilder number(String number) {
        this.number = number;
        return this;
    }

    public CardRequestBuilder customerId(Long customerId) {
        this.customerId = customerId;
        return this;
    }

    public CardRequestBuilder active(boolean active) {
        this.active = active;
        return this;
    }

    public CardRequest build() {
        return new CardRequest(id, number, customerId, active);
    }
}
