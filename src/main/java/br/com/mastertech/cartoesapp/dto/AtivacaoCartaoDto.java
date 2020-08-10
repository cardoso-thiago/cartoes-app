package br.com.mastertech.cartoesapp.dto;

import javax.validation.constraints.NotNull;

public class AtivacaoCartaoDto {
    @NotNull(message = "O estado do cartão não pode ser nulo.")
    private Boolean ativo;

    public AtivacaoCartaoDto() {
    }

    public AtivacaoCartaoDto(Boolean ativo) {
        this.ativo = ativo;
    }

    public Boolean isAtivo() {
        return ativo;
    }
}
