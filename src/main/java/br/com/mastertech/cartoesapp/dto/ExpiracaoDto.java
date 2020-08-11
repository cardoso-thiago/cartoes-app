package br.com.mastertech.cartoesapp.dto;

public class ExpiracaoDto {
    private String status;

    public ExpiracaoDto(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
