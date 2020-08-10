package br.com.mastertech.cartoesapp.entity.builder;

import br.com.mastertech.cartoesapp.entity.Cartao;
import br.com.mastertech.cartoesapp.entity.Pagamento;

public final class PagamentoBuilder {
    private String descricao;
    private double valor;
    private Cartao cartao;

    private PagamentoBuilder() {
    }

    public static PagamentoBuilder aPagamento() {
        return new PagamentoBuilder();
    }

    public PagamentoBuilder descricao(String descricao) {
        this.descricao = descricao;
        return this;
    }

    public PagamentoBuilder valor(double valor) {
        this.valor = valor;
        return this;
    }

    public PagamentoBuilder cartao(Cartao cartao) {
        this.cartao = cartao;
        return this;
    }

    public Pagamento build() {
        return new Pagamento(descricao, valor, cartao);
    }
}
