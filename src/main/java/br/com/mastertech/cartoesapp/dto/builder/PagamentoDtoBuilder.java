package br.com.mastertech.cartoesapp.dto.builder;

import br.com.mastertech.cartoesapp.dto.PagamentoDto;

public final class PagamentoDtoBuilder {
    private Long id;
    private String descricao;
    private double valor;
    private Long cartaoId;

    private PagamentoDtoBuilder() {
    }

    public static PagamentoDtoBuilder aPagamentoDto() {
        return new PagamentoDtoBuilder();
    }

    public PagamentoDtoBuilder id(Long id) {
        this.id = id;
        return this;
    }

    public PagamentoDtoBuilder descricao(String descricao) {
        this.descricao = descricao;
        return this;
    }

    public PagamentoDtoBuilder valor(double valor) {
        this.valor = valor;
        return this;
    }

    public PagamentoDtoBuilder cartaoId(Long cartaoId) {
        this.cartaoId = cartaoId;
        return this;
    }

    public PagamentoDto build() {
        return new PagamentoDto(id, descricao, valor, cartaoId);
    }
}
