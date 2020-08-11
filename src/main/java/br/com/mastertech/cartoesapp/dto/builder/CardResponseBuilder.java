package br.com.mastertech.cartoesapp.dto.builder;

import br.com.mastertech.cartoesapp.dto.CardResponse;

public final class CardResponseBuilder {
    private Long id;
    private String number;
    private Long customerId;

    private CardResponseBuilder() {
    }

    public static CardResponseBuilder aCardResponse() {
        return new CardResponseBuilder();
    }

    public CardResponseBuilder id(Long id) {
        this.id = id;
        return this;
    }

    public CardResponseBuilder number(String number) {
        this.number = number;
        return this;
    }

    public CardResponseBuilder customerId(Long customerId) {
        this.customerId = customerId;
        return this;
    }

    public CardResponse build() {
        return new CardResponse(id, number, customerId, false);
    }
}
