package br.com.mastertech.cartoesapp.entity.builder;

import br.com.mastertech.cartoesapp.entity.Cartao;
import br.com.mastertech.cartoesapp.entity.Fatura;

import java.util.Date;

public final class FaturaBuilder {
    private Double valorPago;
    private Date pagoEm;
    private Cartao cartao;

    private FaturaBuilder() {
    }

    public static FaturaBuilder aFatura() {
        return new FaturaBuilder();
    }

    public FaturaBuilder valorPago(Double valorPago) {
        this.valorPago = valorPago;
        return this;
    }

    public FaturaBuilder pagoEm(Date pagoEm) {
        this.pagoEm = pagoEm;
        return this;
    }

    public FaturaBuilder cartao(Cartao cartao) {
        this.cartao = cartao;
        return this;
    }

    public Fatura build() {
        return new Fatura(valorPago, pagoEm, cartao);
    }
}
