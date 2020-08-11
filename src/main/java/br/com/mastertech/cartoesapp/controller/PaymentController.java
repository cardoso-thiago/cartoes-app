package br.com.mastertech.cartoesapp.controller;

import br.com.mastertech.cartoesapp.dto.PaymentRequest;
import br.com.mastertech.cartoesapp.entity.Payment;
import br.com.mastertech.cartoesapp.exception.DeactivatedCardException;
import br.com.mastertech.cartoesapp.exception.ExpiredCardException;
import br.com.mastertech.cartoesapp.exception.CardNotFoundException;
import br.com.mastertech.cartoesapp.mapper.DataMapper;
import br.com.mastertech.cartoesapp.service.PaymentService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.net.URI;
import java.util.List;

@RestController
@Validated
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/pagamento")
    public ResponseEntity savePayment(@RequestBody @Valid PaymentRequest paymentRequest) throws CardNotFoundException, ExpiredCardException, DeactivatedCardException {
        Payment payment = DataMapper.INSTANCE.paymentRequestToPayment(paymentRequest);
        Payment savedPayment = paymentService.save(paymentRequest.getCardId(), payment);
        return ResponseEntity.created(URI.create("")).body(DataMapper.INSTANCE.paymentToPaymentRequest(savedPayment));
    }

    @GetMapping("/pagamentos/{id_cartao}")
    public ResponseEntity getPayments(
            @Valid
            @NotNull(message = "O id do cartão não pode ser nulo.")
            @Min(value = 1, message = "O id do cartão deve ser um número positivo.")
            @PathVariable("id_cartao") Long cardId) throws CardNotFoundException {
        List<Payment> paymentsByCard = paymentService.getPaymentsByCard(cardId);
        return ResponseEntity.created(URI.create("")).body(DataMapper.INSTANCE.paymentToPaymentRequest(paymentsByCard));
    }
}
