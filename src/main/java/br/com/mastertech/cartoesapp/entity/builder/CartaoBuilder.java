package br.com.mastertech.cartoesapp.entity.builder;

import br.com.mastertech.cartoesapp.entity.Cartao;
import br.com.mastertech.cartoesapp.entity.Cliente;
import br.com.mastertech.cartoesapp.entity.Fatura;
import br.com.mastertech.cartoesapp.entity.Pagamento;

import java.util.ArrayList;
import java.util.List;

public final class CartaoBuilder {
    private String numero;
    private boolean ativo = Boolean.FALSE;
    private boolean expirado = Boolean.TRUE;
    private Cliente cliente;
    private List<Pagamento> pagamentos = new ArrayList<>();
    private List<Fatura> faturas = new ArrayList<>();

    private CartaoBuilder() {
    }

    public static CartaoBuilder aCartao() {
        return new CartaoBuilder();
    }

    public CartaoBuilder numero(String numero) {
        this.numero = numero;
        return this;
    }

    public CartaoBuilder ativo(boolean ativo) {
        this.ativo = ativo;
        return this;
    }

    public CartaoBuilder expirado(boolean expirado) {
        this.expirado = expirado;
        return this;
    }

    public CartaoBuilder cliente(Cliente cliente) {
        this.cliente = cliente;
        return this;
    }

    public CartaoBuilder pagamentos(List<Pagamento> pagamentos) {
        this.pagamentos = pagamentos;
        return this;
    }

    public CartaoBuilder faturas(List<Fatura> faturas) {
        this.faturas = faturas;
        return this;
    }

    public Cartao build() {
        return new Cartao(numero, ativo, expirado, cliente, pagamentos, faturas);
    }
}
