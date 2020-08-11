package br.com.mastertech.cartoesapp.entity;

import br.com.mastertech.cartoesapp.entity.builder.CardBuilder;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "card")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String number;
    @Column
    private boolean active = Boolean.FALSE;
    @Column
    private boolean expired = Boolean.FALSE;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;
    @OneToMany(mappedBy = "card", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Payment> payments = new ArrayList<>();
    @OneToMany(mappedBy = "card", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Invoice> invoices = new ArrayList<>();

    public Card() {
    }

    public Card(String number, boolean active, boolean expired, Customer customer, List<Payment> payments, List<Invoice> invoices) {
        this.number = number;
        this.active = active;
        this.expired = expired;
        this.customer = customer;
        this.payments = payments;
        this.invoices = invoices;
    }

    public static CardBuilder builder() {
        return CardBuilder.aCard();
    }

    public Long getId() {
        return id;
    }

    public String getNumber() {
        return number;
    }

    public boolean isActive() {
        return active;
    }

    public boolean isExpired() {
        return expired;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void setExpired(boolean expired) {
        this.expired = expired;
    }

    public List<Invoice> getInvoices() {
        return invoices;
    }
}
