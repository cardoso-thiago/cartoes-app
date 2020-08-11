package br.com.mastertech.cartoesapp.entity;

import br.com.mastertech.cartoesapp.entity.builder.InvoiceBuilder;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "invoice")
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "payed_value")
    private Double payedValue;
    @Column(name = "payed_in")
    @Temporal(TemporalType.DATE)
    private Date payedIn;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "card_id")
    private Card card;

    public Invoice() {
    }

    public Invoice(Double payedValue, Date payedIn, Card card) {
        this.payedValue = payedValue;
        this.payedIn = payedIn;
        this.card = card;
    }

    public static InvoiceBuilder builder() {
        return InvoiceBuilder.anInvoice();
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

    public Card getCard() {
        return card;
    }
}
