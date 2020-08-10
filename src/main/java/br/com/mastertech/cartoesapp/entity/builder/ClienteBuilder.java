package br.com.mastertech.cartoesapp.entity.builder;

import br.com.mastertech.cartoesapp.entity.Cartao;
import br.com.mastertech.cartoesapp.entity.Cliente;

import java.util.ArrayList;
import java.util.List;

public final class ClienteBuilder {
    private String nome;
    private List<Cartao> cartoes = new ArrayList<>();

    private ClienteBuilder() {
    }

    public static ClienteBuilder aCliente() {
        return new ClienteBuilder();
    }

    public ClienteBuilder nome(String nome) {
        this.nome = nome;
        return this;
    }

    public ClienteBuilder cartoes(List<Cartao> cartoes) {
        this.cartoes = cartoes;
        return this;
    }

    public Cliente build() {
        return new Cliente(nome, cartoes);
    }
}
