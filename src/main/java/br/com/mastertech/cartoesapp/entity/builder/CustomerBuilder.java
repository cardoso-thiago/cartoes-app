package br.com.mastertech.cartoesapp.entity.builder;

import br.com.mastertech.cartoesapp.entity.Card;
import br.com.mastertech.cartoesapp.entity.Customer;

import java.util.ArrayList;
import java.util.List;

public final class CustomerBuilder {
    private String name;
    private List<Card> cards = new ArrayList<>();

    private CustomerBuilder() {
    }

    public static CustomerBuilder aCustomer() {
        return new CustomerBuilder();
    }

    public CustomerBuilder name(String name) {
        this.name = name;
        return this;
    }

    public CustomerBuilder cards(List<Card> cards) {
        this.cards = cards;
        return this;
    }

    public Customer build() {
        return new Customer(name, cards);
    }
}
