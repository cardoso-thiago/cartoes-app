package br.com.mastertech.cartoesapp.controller;

import br.com.mastertech.cartoesapp.dto.PagamentoDto;
import br.com.mastertech.cartoesapp.entity.Pagamento;
import br.com.mastertech.cartoesapp.exception.CartaoNotFoundException;
import br.com.mastertech.cartoesapp.mapper.DataMapper;
import br.com.mastertech.cartoesapp.service.PagamentoService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.net.URI;
import java.util.List;

@RestController
@Validated
public class PagamentoController {

    private final PagamentoService pagamentoService;

    public PagamentoController(PagamentoService pagamentoService) {
        this.pagamentoService = pagamentoService;
    }

    @PostMapping("/pagamento")
    public ResponseEntity saveCartao(@RequestBody @Valid PagamentoDto pagamentoDto) throws CartaoNotFoundException {
        Pagamento pagamento = DataMapper.INSTANCE.pagamentoDtoToPagamento(pagamentoDto);
        Pagamento savedPagamento = pagamentoService.save(pagamentoDto.getCartaoId(), pagamento);
        return ResponseEntity.created(URI.create("")).body(DataMapper.INSTANCE.pagamentoToPagamentoDto(savedPagamento));
    }

    @GetMapping("/pagamentos/{id_cartao}")
    public ResponseEntity getPagamentos(
            @Valid
            @Min(value = 1, message = "O id do cartão deve ser um número positivo.")
            @PathVariable("id_cartao") Long cartaoId) throws CartaoNotFoundException {
        List<Pagamento> pagamentosPorCartao = pagamentoService.getPagamentosPorCartao(cartaoId);
        return ResponseEntity.created(URI.create("")).body(DataMapper.INSTANCE.pagamentoToPagamentoDto(pagamentosPorCartao));
    }
}
