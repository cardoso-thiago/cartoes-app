package br.com.mastertech.cartoesapp.entity;

import br.com.mastertech.cartoesapp.entity.builder.PagamentoBuilder;

import javax.persistence.*;

@Entity
@Table(name = "pagamento")
public class Pagamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "descricao")
    private String descricao;
    @Column(name = "valor")
    private double valor;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cartao_id")
    private Cartao cartao;

    public Pagamento() {
    }

    public Pagamento(String descricao, double valor, Cartao cartao) {
        this.descricao = descricao;
        this.valor = valor;
        this.cartao = cartao;
    }

    public static PagamentoBuilder builder() {
        return PagamentoBuilder.aPagamento();
    }

    public Long getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getValor() {
        return valor;
    }

    public Cartao getCartao() {
        return cartao;
    }

    public void setCartao(Cartao cartao) {
        this.cartao = cartao;
    }
}
