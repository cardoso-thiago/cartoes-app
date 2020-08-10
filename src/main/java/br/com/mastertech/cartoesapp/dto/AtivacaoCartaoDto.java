package br.com.mastertech.cartoesapp.dto;

import javax.validation.constraints.NotNull;

public class AtivacaoCartaoDto {
    @NotNull(message = "O estado do cartão não pode ser nulo.")
    private boolean ativo;

    public AtivacaoCartaoDto() {
    }

    public AtivacaoCartaoDto(boolean ativo) {
        this.ativo = ativo;
    }

    public boolean isAtivo() {
        return ativo;
    }
}
