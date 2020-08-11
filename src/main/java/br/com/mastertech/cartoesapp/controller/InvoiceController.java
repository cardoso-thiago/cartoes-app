package br.com.mastertech.cartoesapp.controller;

import br.com.mastertech.cartoesapp.dto.CardExpirationRequest;
import br.com.mastertech.cartoesapp.dto.PaymentRequest;
import br.com.mastertech.cartoesapp.exception.CardNotFoundException;
import br.com.mastertech.cartoesapp.exception.CustomerNotFoundException;
import br.com.mastertech.cartoesapp.mapper.DataMapper;
import br.com.mastertech.cartoesapp.service.InvoiceService;
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
public class InvoiceController {

    private final InvoiceService invoiceService;

    public InvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @GetMapping("/{cliente-id}/{cartao-id}")
    public ResponseEntity getInvoice(@Valid
                                     @NotNull(message = "O id do cliente não pode ser nulo.")
                                     @Min(value = 1, message = "O id do cliente deve ser um número positivo.")
                                     @PathVariable("cliente-id") Long customerId,
                                     @Valid
                                     @NotNull(message = "O id do cartão não pode ser nulo.")
                                     @Min(value = 1, message = "O id do cartão deve ser um número positivo.")
                                     @PathVariable("cartao-id") Long cardId) throws CardNotFoundException, CustomerNotFoundException {
        List<PaymentRequest> paymentRequests = DataMapper.INSTANCE.paymentToPaymentRequest(invoiceService.getInvoice(customerId, cardId));
        return paymentRequests.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(paymentRequests);
    }

    @PostMapping("/{cliente-id}/{cartao-id}/pagar")
    public ResponseEntity payInvoice(@Valid
                                     @NotNull(message = "O id do cliente não pode ser nulo.")
                                     @Min(value = 1, message = "O id do cliente deve ser um número positivo.")
                                     @PathVariable("cliente-id") Long customerId,
                                     @Valid
                                     @NotNull(message = "O id do cartão não pode ser nulo.")
                                     @Min(value = 1, message = "O id do cartão deve ser um número positivo.")
                                     @PathVariable("cartao-id") Long cardId) throws CardNotFoundException, CustomerNotFoundException {
        return ResponseEntity.ok(DataMapper.INSTANCE.invoiceToInvoiceRequest(invoiceService.payInvoice(customerId, cardId)));
    }

    @PostMapping("/{cliente-id}/{cartao-id}/expirar")
    public ResponseEntity expireCard(@Valid
                                     @NotNull(message = "O id do cliente não pode ser nulo.")
                                     @Min(value = 1, message = "O id do cliente deve ser um número positivo.")
                                     @PathVariable("cliente-id") Long customerId,
                                     @Valid
                                     @NotNull(message = "O id do cartão não pode ser nulo.")
                                     @Min(value = 1, message = "O id do cartão deve ser um número positivo.")
                                     @PathVariable("cartao-id") Long cardId) throws CardNotFoundException, CustomerNotFoundException {
        invoiceService.expireCard(customerId, cardId);
        return ResponseEntity.ok(new CardExpirationRequest("ok"));
    }
}
