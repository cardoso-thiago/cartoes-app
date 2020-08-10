package br.com.mastertech.cartoesapp.entity;

import br.com.mastertech.cartoesapp.entity.builder.CartaoBuilder;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cartao")
public class Cartao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "numero")
    private String numero;
    @Column(name = "ativo")
    private boolean ativo = Boolean.FALSE;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
    @OneToMany(mappedBy = "cartao", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Pagamento> pagamentos = new ArrayList<>();

    public Cartao() {
    }

    public Cartao(String numero, boolean ativo, Cliente cliente, List<Pagamento> pagamentos) {
        this.numero = numero;
        this.ativo = ativo;
        this.cliente = cliente;
        this.pagamentos = pagamentos;
    }

    public static CartaoBuilder builder() {
        return CartaoBuilder.aCartao();
    }

    public Long getId() {
        return id;
    }

    public String getNumero() {
        return numero;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<Pagamento> getPagamentos() {
        return pagamentos;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
}
