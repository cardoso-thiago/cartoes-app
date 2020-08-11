package br.com.mastertech.cartoesapp.entity.builder;

import br.com.mastertech.cartoesapp.entity.Card;
import br.com.mastertech.cartoesapp.entity.Payment;

public final class PaymentBuilder {
    private String description;
    private double value;
    private Card card;

    private PaymentBuilder() {
    }

    public static PaymentBuilder aPayment() {
        return new PaymentBuilder();
    }

    public PaymentBuilder description(String description) {
        this.description = description;
        return this;
    }

    public PaymentBuilder value(double value) {
        this.value = value;
        return this;
    }

    public PaymentBuilder card(Card card) {
        this.card = card;
        return this;
    }

    public Payment build() {
        return new Payment(description, value, card);
    }
}
