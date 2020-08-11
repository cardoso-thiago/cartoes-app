package br.com.mastertech.cartoesapp.dto.builder;

import br.com.mastertech.cartoesapp.dto.InvoiceRequest;

import java.util.Date;

public final class InvoiceRequestBuilder {
    private Long id;
    private Double payedValue;
    private Date payedIn;

    private InvoiceRequestBuilder() {
    }

    public static InvoiceRequestBuilder anInvoiceRequest() {
        return new InvoiceRequestBuilder();
    }

    public InvoiceRequestBuilder id(Long id) {
        this.id = id;
        return this;
    }

    public InvoiceRequestBuilder payedValue(Double payedValue) {
        this.payedValue = payedValue;
        return this;
    }

    public InvoiceRequestBuilder payedIn(Date payedIn) {
        this.payedIn = payedIn;
        return this;
    }

    public InvoiceRequest build() {
        return new InvoiceRequest(id, payedValue, payedIn);
    }
}
