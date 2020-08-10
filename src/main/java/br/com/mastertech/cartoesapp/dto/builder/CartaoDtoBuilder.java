package br.com.mastertech.cartoesapp.dto.builder;

import br.com.mastertech.cartoesapp.dto.CartaoDto;

public final class CartaoDtoBuilder {
    private Long id;
    private String numero;
    private Long clienteId;
    private boolean ativo = Boolean.FALSE;

    private CartaoDtoBuilder() {
    }

    public static CartaoDtoBuilder aCartaoDto() {
        return new CartaoDtoBuilder();
    }

    public CartaoDtoBuilder id(Long id) {
        this.id = id;
        return this;
    }

    public CartaoDtoBuilder numero(String numero) {
        this.numero = numero;
        return this;
    }

    public CartaoDtoBuilder clienteId(Long clienteId) {
        this.clienteId = clienteId;
        return this;
    }

    public CartaoDtoBuilder ativo(boolean ativo) {
        this.ativo = ativo;
        return this;
    }

    public CartaoDto build() {
        return new CartaoDto(id, numero, clienteId, ativo);
    }
}
