package br.com.mastertech.cartoesapp.dto;

import javax.validation.constraints.NotNull;

public class AtivacaoCartaoDto {
    @NotNull
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
