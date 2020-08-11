package br.com.mastertech.cartoesapp.entity.builder;

import br.com.mastertech.cartoesapp.entity.Card;
import br.com.mastertech.cartoesapp.entity.Customer;
import br.com.mastertech.cartoesapp.entity.Invoice;
import br.com.mastertech.cartoesapp.entity.Payment;

import java.util.ArrayList;
import java.util.List;

public final class CardBuilder {
    private String number;
    private boolean active = Boolean.FALSE;
    private boolean expired = Boolean.FALSE;
    private Customer customer;
    private List<Payment> payments = new ArrayList<>();
    private List<Invoice> invoices = new ArrayList<>();

    private CardBuilder() {
    }

    public static CardBuilder aCard() {
        return new CardBuilder();
    }

    public CardBuilder number(String number) {
        this.number = number;
        return this;
    }

    public CardBuilder active(boolean active) {
        this.active = active;
        return this;
    }

    public CardBuilder expired(boolean expired) {
        this.expired = expired;
        return this;
    }

    public CardBuilder customer(Customer customer) {
        this.customer = customer;
        return this;
    }

    public CardBuilder payments(List<Payment> payments) {
        this.payments = payments;
        return this;
    }

    public CardBuilder invoices(List<Invoice> invoices) {
        this.invoices = invoices;
        return this;
    }

    public Card build() {
        return new Card(number, active, expired, customer, payments, invoices);
    }
}
