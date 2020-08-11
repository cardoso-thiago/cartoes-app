package br.com.mastertech.cartoesapp.dto.builder;

import br.com.mastertech.cartoesapp.dto.FaturaDto;

import java.util.Date;

public final class FaturaDtoBuilder {
    private Long id;
    private Double valorPago;
    private Date pagoEm;

    private FaturaDtoBuilder() {
    }

    public static FaturaDtoBuilder aFaturaDto() {
        return new FaturaDtoBuilder();
    }

    public FaturaDtoBuilder id(Long id) {
        this.id = id;
        return this;
    }

    public FaturaDtoBuilder valorPago(Double valorPago) {
        this.valorPago = valorPago;
        return this;
    }

    public FaturaDtoBuilder pagoEm(Date pagoEm) {
        this.pagoEm = pagoEm;
        return this;
    }

    public FaturaDto build() {
        return new FaturaDto(id, valorPago, pagoEm);
    }
}
