package br.com.mastertech.cartoesapp.dto;

import br.com.mastertech.cartoesapp.dto.builder.InvoiceRequestBuilder;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class InvoiceRequest {
    private Long id;
    @JsonProperty("valorPago")
    private Double payedValue;
    @JsonProperty("pagoEm")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date payedIn;

    public InvoiceRequest(Long id, Double payedValue, Date payedIn) {
        this.id = id;
        this.payedValue = payedValue;
        this.payedIn = payedIn;
    }

    public static InvoiceRequestBuilder builder() {
        return InvoiceRequestBuilder.anInvoiceRequest();
    }

    public Long getId() {
        return id;
    }

    public Double getPayedValue() {
        return payedValue;
    }

    public Date getPayedIn() {
        return payedIn;
    }
}
