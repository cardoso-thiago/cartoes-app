package br.com.mastertech.cartoesapp.dto.builder;

import br.com.mastertech.cartoesapp.dto.ClienteDto;

public final class ClienteDtoBuilder {
    private Long id;
    private String nome;

    private ClienteDtoBuilder() {
    }

    public static ClienteDtoBuilder aClienteDto() {
        return new ClienteDtoBuilder();
    }

    public ClienteDtoBuilder id(Long id) {
        this.id = id;
        return this;
    }

    public ClienteDtoBuilder nome(String nome) {
        this.nome = nome;
        return this;
    }

    public ClienteDto build() {
        return new ClienteDto(id, nome);
    }
}
