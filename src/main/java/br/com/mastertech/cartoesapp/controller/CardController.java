package br.com.mastertech.cartoesapp.controller;

import br.com.mastertech.cartoesapp.dto.CardActivationRequest;
import br.com.mastertech.cartoesapp.dto.CardRequest;
import br.com.mastertech.cartoesapp.entity.Card;
import br.com.mastertech.cartoesapp.exception.CardAlreadyExistsException;
import br.com.mastertech.cartoesapp.exception.CardNotFoundException;
import br.com.mastertech.cartoesapp.exception.CustomerNotFoundException;
import br.com.mastertech.cartoesapp.mapper.DataMapper;
import br.com.mastertech.cartoesapp.service.CardService;
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
public class CardController {

    private final CardService cardService;

    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    @GetMapping
    public ResponseEntity getAllCards() {
        List<CardRequest> cardRequestList = DataMapper.INSTANCE.cardToCardRequest(cardService.findAll());
        return ResponseEntity.ok(cardRequestList);
    }

    @PostMapping
    public ResponseEntity saveCard(@RequestBody @Valid CardRequest cardRequest) throws CustomerNotFoundException, CardAlreadyExistsException {
        Card card = DataMapper.INSTANCE.cardRequestToCard(cardRequest);
        CardRequest savedCard = DataMapper.INSTANCE.cardToCardRequest(cardService.save(cardRequest.getCustomerId(), card));
        return ResponseEntity.created(URI.create("")).body(savedCard);
    }

    @PatchMapping("/{numero}")
    public ResponseEntity activateCard(
            @Valid
            @NotNull(message = "O numero do cartão deve ser informado.")
            @NotEmpty(message = "O numero do cartão deve ser informado.")
            @PathVariable("numero") String number, @RequestBody @Valid CardActivationRequest cardActivationRequest) throws CardNotFoundException {
        Card patchedCard = cardService.activateCard(number, cardActivationRequest.isAtivo());
        return ResponseEntity.ok().body(DataMapper.INSTANCE.cardToCardRequest(patchedCard));
    }

    @GetMapping("/{numero}")
    public ResponseEntity getCard(
            @Valid
            @NotNull(message = "O numero do cartão deve ser informado.")
            @NotEmpty(message = "O numero do cartão deve ser informado.")
            @PathVariable("numero") String number) throws CardNotFoundException {
        Card card = cardService.findByNumber(number);
        return ResponseEntity.ok().body(DataMapper.INSTANCE.cardToCardResponse(card));
    }
}
