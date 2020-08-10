package br.com.mastertech.cartoesapp.dto;

import br.com.mastertech.cartoesapp.dto.builder.CartaoDtoBuilder;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class CartaoDto {
    private Long id;
    @NotNull(message = "O numero do cartao não pode ser nulo.")
    @NotEmpty(message = "O numero do cartao não pode ser vazio.")
    private String numero;
    @Min(value = 0, message = "O id do cliente deve ser um número positivo.")
    private Long clienteId;
    private boolean ativo;

    public CartaoDto(Long id, String numero, Long clienteId, boolean ativo) {
        this.id = id;
        this.numero = numero;
        this.clienteId = clienteId;
        this.ativo = ativo;
    }

    public static CartaoDtoBuilder builder() {
        return CartaoDtoBuilder.aCartaoDto();
    }

    public Long getId() {
        return id;
    }

    public String getNumero() {
        return numero;
    }

    public Long getClienteId() {
        return clienteId;
    }

    public boolean isAtivo() {
        return ativo;
    }
}
