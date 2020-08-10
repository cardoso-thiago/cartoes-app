package br.com.mastertech.cartoesapp.dto;

import br.com.mastertech.cartoesapp.dto.builder.ClienteDtoBuilder;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class ClienteDto {
    private Long id;
    @NotNull(message = "O nome do cliente não pode ser nulo.")
    @NotEmpty(message = "O nome do cliente não pode ser vazio.")
    private String nome;

    public ClienteDto(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public static ClienteDtoBuilder builder() {
        return ClienteDtoBuilder.aClienteDto();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}
