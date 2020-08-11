package br.com.mastertech.cartoesapp.entity.builder;

import br.com.mastertech.cartoesapp.entity.Card;
import br.com.mastertech.cartoesapp.entity.Invoice;

import java.util.Date;

public final class InvoiceBuilder {
    private Double payedValue;
    private Date payedIn;
    private Card card;

    private InvoiceBuilder() {
    }

    public static InvoiceBuilder anInvoice() {
        return new InvoiceBuilder();
    }

    public InvoiceBuilder payedValue(Double payedValue) {
        this.payedValue = payedValue;
        return this;
    }

    public InvoiceBuilder payedIn(Date payedIn) {
        this.payedIn = payedIn;
        return this;
    }

    public InvoiceBuilder card(Card card) {
        this.card = card;
        return this;
    }

    public Invoice build() {
        return new Invoice(payedValue, payedIn, card);
    }
}
