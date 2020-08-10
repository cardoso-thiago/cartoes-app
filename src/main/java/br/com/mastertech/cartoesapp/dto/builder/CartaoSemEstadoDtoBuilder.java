package br.com.mastertech.cartoesapp.dto.builder;

import br.com.mastertech.cartoesapp.dto.CartaoSemEstadoDto;

public final class CartaoSemEstadoDtoBuilder {
    private Long id;
    private String numero;
    private Long clienteId;

    private CartaoSemEstadoDtoBuilder() {
    }

    public static CartaoSemEstadoDtoBuilder aCartaoSemEstadoDto() {
        return new CartaoSemEstadoDtoBuilder();
    }

    public CartaoSemEstadoDtoBuilder id(Long id) {
        this.id = id;
        return this;
    }

    public CartaoSemEstadoDtoBuilder numero(String numero) {
        this.numero = numero;
        return this;
    }

    public CartaoSemEstadoDtoBuilder clienteId(Long clienteId) {
        this.clienteId = clienteId;
        return this;
    }

    public CartaoSemEstadoDto build() {
        return new CartaoSemEstadoDto(id, numero, clienteId, false);
    }
}
