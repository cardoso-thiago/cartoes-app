package br.com.mastertech.cartoesapp.controller;

import br.com.mastertech.cartoesapp.dto.AtivacaoCartaoDto;
import br.com.mastertech.cartoesapp.dto.CartaoDto;
import br.com.mastertech.cartoesapp.entity.Cartao;
import br.com.mastertech.cartoesapp.exception.CartaoAlreadyExistsException;
import br.com.mastertech.cartoesapp.exception.CartaoNotFoundException;
import br.com.mastertech.cartoesapp.exception.ClienteNotFoundException;
import br.com.mastertech.cartoesapp.mapper.DataMapper;
import br.com.mastertech.cartoesapp.service.CartaoService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.net.URI;
import java.util.List;

@RestController
@Validated
@RequestMapping("/cartao")
public class CartaoController {

    private final CartaoService cartaoService;

    public CartaoController(CartaoService cartaoService) {
        this.cartaoService = cartaoService;
    }

    @GetMapping
    public ResponseEntity getAllCartoes() {
        List<CartaoDto> cartaoDtoList = DataMapper.INSTANCE.cartaoToCartaoDto(cartaoService.findAll());
        return ResponseEntity.ok(cartaoDtoList);
    }

    @PostMapping
    public ResponseEntity saveCartao(@RequestBody @Valid CartaoDto cartaoDto) throws ClienteNotFoundException, CartaoAlreadyExistsException {
        Cartao cartao = DataMapper.INSTANCE.cartaoDtoToCartao(cartaoDto);
        CartaoDto savedCartao = DataMapper.INSTANCE.cartaoToCartaoDto(cartaoService.save(cartaoDto.getClienteId(), cartao));
        return ResponseEntity.created(URI.create("")).body(savedCartao);
    }

    @PatchMapping("/{numero}")
    public ResponseEntity ativaCartao(
            @Valid
            @NotNull(message = "O numero do cartão deve ser informado.")
            @NotEmpty(message = "O numero do cartão deve ser informado.")
            @PathVariable("numero") String numeroCartao, @RequestBody @Valid AtivacaoCartaoDto ativacaoCartaoDto) throws CartaoNotFoundException {
        Cartao patchedCartao = cartaoService.ativacaoCartao(numeroCartao, ativacaoCartaoDto.isAtivo());
        return ResponseEntity.ok().body(DataMapper.INSTANCE.cartaoToCartaoDto(patchedCartao));
    }

    @GetMapping("/{numero}")
    public ResponseEntity getCartao(
            @Valid
            @NotNull(message = "O numero do cartão deve ser informado.")
            @NotEmpty(message = "O numero do cartão deve ser informado.")
            @PathVariable("numero") String numeroCartao) throws CartaoNotFoundException {
        Cartao cartao = cartaoService.findByNumero(numeroCartao);
        return ResponseEntity.ok().body(DataMapper.INSTANCE.cartaoToCartaoSemEstadoDto(cartao));
    }
}
