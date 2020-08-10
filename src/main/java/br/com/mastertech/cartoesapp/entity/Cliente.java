package br.com.mastertech.cartoesapp.entity;

import br.com.mastertech.cartoesapp.entity.builder.ClienteBuilder;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Cartao> cartoes = new ArrayList<>();

    public Cliente() {
    }

    public Cliente(String nome, List<Cartao> cartoes) {
        this.nome = nome;
        this.cartoes = cartoes;
    }

    public static ClienteBuilder builder() {
        return ClienteBuilder.aCliente();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public List<Cartao> getCartoes() {
        return cartoes;
    }
}
