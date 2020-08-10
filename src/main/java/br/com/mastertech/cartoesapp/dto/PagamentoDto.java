package br.com.mastertech.cartoesapp.dto;

import br.com.mastertech.cartoesapp.dto.builder.PagamentoDtoBuilder;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class PagamentoDto {
    private Long id;
    @NotNull(message = "A descrição do pagamento não pode ser nula.")
    @NotEmpty(message = "A descrição do pagamento não pode ser vazia.")
    private String descricao;
    @DecimalMin(value = "0.01", message = "O valor da transação deve ser um número positivo.")
    private double valor;
    @Min(value = 1, message = "O id do cartão deve ser um número positivo.")
    @JsonProperty("cartao_id")
    private Long cartaoId;

    public PagamentoDto(Long id, String descricao, double valor, Long cartaoId) {
        this.id = id;
        this.descricao = descricao;
        this.valor = valor;
        this.cartaoId = cartaoId;
    }

    public static PagamentoDtoBuilder builder() {
        return PagamentoDtoBuilder.aPagamentoDto();
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

    public Long getCartaoId() {
        return cartaoId;
    }
}
