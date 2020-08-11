package br.com.mastertech.cartoesapp.controller;

import br.com.mastertech.cartoesapp.dto.ExpiracaoDto;
import br.com.mastertech.cartoesapp.dto.PagamentoDto;
import br.com.mastertech.cartoesapp.exception.CartaoNotFoundException;
import br.com.mastertech.cartoesapp.exception.ClienteNotFoundException;
import br.com.mastertech.cartoesapp.mapper.DataMapper;
import br.com.mastertech.cartoesapp.service.FaturaService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@Validated
@RequestMapping("/fatura")
public class FaturaController {

    private final FaturaService faturaService;

    public FaturaController(FaturaService faturaService) {
        this.faturaService = faturaService;
    }

    @GetMapping("/{cliente-id}/{cartao-id}")
    public ResponseEntity getFatura(@Valid
                                    @NotNull(message = "O id do cliente não pode ser nulo.")
                                    @Min(value = 1, message = "O id do cliente deve ser um número positivo.")
                                    @PathVariable("cliente-id") Long clienteId,
                                    @Valid
                                    @NotNull(message = "O id do cartão não pode ser nulo.")
                                    @Min(value = 1, message = "O id do cartão deve ser um número positivo.")
                                    @PathVariable("cartao-id") Long cartaoId) throws CartaoNotFoundException, ClienteNotFoundException {
        List<PagamentoDto> pagamentoDtos = DataMapper.INSTANCE.pagamentoToPagamentoDto(faturaService.getFatura(clienteId, cartaoId));
        return pagamentoDtos.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(pagamentoDtos);
    }

    @PostMapping("/{cliente-id}/{cartao-id}/pagar")
    public ResponseEntity pagar(@Valid
                                @NotNull(message = "O id do cliente não pode ser nulo.")
                                @Min(value = 1, message = "O id do cliente deve ser um número positivo.")
                                @PathVariable("cliente-id") Long clienteId,
                                @Valid
                                @NotNull(message = "O id do cartão não pode ser nulo.")
                                @Min(value = 1, message = "O id do cartão deve ser um número positivo.")
                                @PathVariable("cartao-id") Long cartaoId) throws CartaoNotFoundException, ClienteNotFoundException {
        return ResponseEntity.ok(DataMapper.INSTANCE.faturaToFaturaDto(faturaService.pagar(clienteId, cartaoId)));
    }

    @PostMapping("/{cliente-id}/{cartao-id}/expirar")
    public ResponseEntity expirar(@Valid
                                @NotNull(message = "O id do cliente não pode ser nulo.")
                                @Min(value = 1, message = "O id do cliente deve ser um número positivo.")
                                @PathVariable("cliente-id") Long clienteId,
                                @Valid
                                @NotNull(message = "O id do cartão não pode ser nulo.")
                                @Min(value = 1, message = "O id do cartão deve ser um número positivo.")
                                @PathVariable("cartao-id") Long cartaoId) throws CartaoNotFoundException, ClienteNotFoundException {
        faturaService.expirarCartao(clienteId, cartaoId);
        return ResponseEntity.ok(new ExpiracaoDto("ok"));
    }
}
