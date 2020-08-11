package br.com.mastertech.cartoesapp.dto;

import br.com.mastertech.cartoesapp.dto.builder.FaturaDtoBuilder;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class FaturaDto {
    private Long id;
    private Double valorPago;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date pagoEm;

    public FaturaDto(Long id, Double valorPago, Date pagoEm) {
        this.id = id;
        this.valorPago = valorPago;
        this.pagoEm = pagoEm;
    }

    public static FaturaDtoBuilder builder() {
        return FaturaDtoBuilder.aFaturaDto();
    }

    public Long getId() {
        return id;
    }

    public Double getValorPago() {
        return valorPago;
    }

    public Date getPagoEm() {
        return pagoEm;
    }
}
