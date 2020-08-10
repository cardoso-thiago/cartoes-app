package br.com.mastertech.cartoesapp.dto;

import br.com.mastertech.cartoesapp.dto.builder.CartaoSemEstadoDtoBuilder;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class CartaoSemEstadoDto {
    private Long id;
    @NotNull(message = "O numero do cartao não pode ser nulo.")
    @NotEmpty(message = "O numero do cartao não pode ser vazio.")
    private String numero;
    @NotNull(message = "O id do cliente não pode ser nulo.")
    @Min(value = 1, message = "O id do cliente deve ser um número positivo.")
    private Long clienteId;

    public CartaoSemEstadoDto(Long id, String numero, Long clienteId, boolean ativo) {
        this.id = id;
        this.numero = numero;
        this.clienteId = clienteId;
    }

    public static CartaoSemEstadoDtoBuilder builder() {
        return CartaoSemEstadoDtoBuilder.aCartaoSemEstadoDto();
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
}
