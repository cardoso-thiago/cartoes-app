package br.com.mastertech.cartoesapp.service;

import br.com.mastertech.cartoesapp.entity.Card;
import br.com.mastertech.cartoesapp.entity.Customer;
import br.com.mastertech.cartoesapp.entity.Invoice;
import br.com.mastertech.cartoesapp.entity.Payment;
import br.com.mastertech.cartoesapp.entity.builder.InvoiceBuilder;
import br.com.mastertech.cartoesapp.exception.CardNotFoundException;
import br.com.mastertech.cartoesapp.exception.CustomerNotFoundException;
import br.com.mastertech.cartoesapp.repository.CardRepository;
import br.com.mastertech.cartoesapp.repository.CustomerRepository;
import br.com.mastertech.cartoesapp.repository.InvoiceRepository;
import br.com.mastertech.cartoesapp.repository.PaymentRepository;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.Date;
import java.util.List;

@Service
public class InvoiceService {

    private final CardRepository cardRepository;
    private final CustomerRepository customerRepository;
    private final InvoiceRepository invoiceRepository;
    private final PaymentRepository paymentRepository;

    public InvoiceService(CardRepository cardRepository, CustomerRepository customerRepository, InvoiceRepository invoiceRepository, PaymentRepository paymentRepository) {
        this.cardRepository = cardRepository;
        this.customerRepository = customerRepository;
        this.invoiceRepository = invoiceRepository;
        this.paymentRepository = paymentRepository;
    }

    public List<Payment> getInvoice(Long customerId, Long cardId) throws CardNotFoundException, CustomerNotFoundException {
        return getCard(customerId, cardId).getPayments();
    }

    public Invoice payInvoice(Long customerId, Long cardId) throws CustomerNotFoundException, CardNotFoundException {
        Card card = getCard(customerId, cardId);
        List<Payment> payments = card.getPayments();

        double sumInvoice = payments.stream().mapToDouble(Payment::getValue).sum();
        Invoice invoice = InvoiceBuilder.anInvoice().card(card).payedValue(sumInvoice).payedIn(new Date()).build();

        paymentRepository.deleteAll(payments);

        return invoiceRepository.save(invoice);
    }

    public void expireCard(Long customerId, Long cardId) throws CustomerNotFoundException, CardNotFoundException {
        Card card = getCard(customerId, cardId);
        card.setExpired(Boolean.TRUE);
        cardRepository.save(card);
    }

    private Card getCard(Long customerId, Long cardId) throws CustomerNotFoundException, CardNotFoundException {
        Customer customer = customerRepository.findById(customerId).orElseThrow(() -> new CustomerNotFoundException("Cliente não encontrado."));

        Card card = cardRepository.findByIdAndCustomerId(cardId, customerId).orElseThrow(()
                -> new CardNotFoundException(MessageFormat.format("Cartão não encontrado para o cliente {0}",
                customer.getName())));

        return card;
    }
}
