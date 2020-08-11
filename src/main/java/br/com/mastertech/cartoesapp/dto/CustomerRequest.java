package br.com.mastertech.cartoesapp.dto;

import br.com.mastertech.cartoesapp.dto.builder.CustomerRequestBuilder;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class CustomerRequest {
    private Long id;
    @NotNull(message = "O nome do cliente não pode ser nulo.")
    @NotEmpty(message = "O nome do cliente não pode ser vazio.")
    @JsonProperty("nome")
    private String name;

    public CustomerRequest(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public static CustomerRequestBuilder builder() {
        return CustomerRequestBuilder.aCustomerRequest();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
