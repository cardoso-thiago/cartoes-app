package br.com.mastertech.cartoesapp.entity;

import br.com.mastertech.cartoesapp.entity.builder.FaturaBuilder;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "fatura")
public class Fatura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "valor_pago")
    private Double valorPago;
    @Column(name = "pago_em")
    @Temporal(TemporalType.DATE)
    private Date pagoEm;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cartao_id")
    private Cartao cartao;

    public Fatura() {
    }

    public Fatura(Double valorPago, Date pagoEm, Cartao cartao) {
        this.valorPago = valorPago;
        this.pagoEm = pagoEm;
        this.cartao = cartao;
    }

    public static FaturaBuilder builder() {
        return FaturaBuilder.aFatura();
    }

    public Long getId() {
        return id;
    }

    public Double getValorPago() {
        return valorPago;
    }

    public Date getPagoEm() {
        return pagoEm;
    }

    public Cartao getCartao() {
        return cartao;
    }
}
