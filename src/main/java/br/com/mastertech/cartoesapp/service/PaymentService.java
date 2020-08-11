package br.com.mastertech.cartoesapp.service;

import br.com.mastertech.cartoesapp.entity.Card;
import br.com.mastertech.cartoesapp.entity.Payment;
import br.com.mastertech.cartoesapp.exception.DeactivatedCardException;
import br.com.mastertech.cartoesapp.exception.ExpiredCardException;
import br.com.mastertech.cartoesapp.exception.CardNotFoundException;
import br.com.mastertech.cartoesapp.repository.CardRepository;
import br.com.mastertech.cartoesapp.repository.PaymentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {
    private final PaymentRepository paymentRepository;
    private final CardRepository cardRepository;

    public PaymentService(PaymentRepository paymentRepository, CardRepository cardRepository) {
        this.paymentRepository = paymentRepository;
        this.cardRepository = cardRepository;
    }

    public Payment save(Long cardId, Payment payment) throws CardNotFoundException, ExpiredCardException, DeactivatedCardException {
        Card card = getCardImpl(cardId);
        if(!card.isActive()) {
            throw new DeactivatedCardException("Não é possível realizar o pagamento, o cartão está desativado.");
        }
        if(card.isExpired()) {
            throw new ExpiredCardException("Não é possível realizar o pagamento, o cartão está expirado.");
        }
        payment.setCard(card);
        return paymentRepository.save(payment);
    }

    public List<Payment> getPaymentsByCard(Long cardId) throws CardNotFoundException {
        Card card = getCardImpl(cardId);
        return paymentRepository.findAllByCard(card);
    }

    private Card getCardImpl(Long cardId) throws CardNotFoundException {
        return cardRepository.findById(cardId).orElseThrow(() -> new CardNotFoundException("O cartão informado não foi encontrado."));
    }
}
