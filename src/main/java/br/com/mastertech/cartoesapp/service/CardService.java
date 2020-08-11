package br.com.mastertech.cartoesapp.service;

import br.com.mastertech.cartoesapp.entity.Card;
import br.com.mastertech.cartoesapp.entity.Customer;
import br.com.mastertech.cartoesapp.exception.CardAlreadyExistsException;
import br.com.mastertech.cartoesapp.exception.CardNotFoundException;
import br.com.mastertech.cartoesapp.exception.CustomerNotFoundException;
import br.com.mastertech.cartoesapp.repository.CardRepository;
import br.com.mastertech.cartoesapp.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class CardService {
    private final CardRepository cardRepository;
    private final CustomerRepository customerRepository;

    public CardService(CardRepository cardRepository, CustomerRepository customerRepository) {
        this.cardRepository = cardRepository;
        this.customerRepository = customerRepository;
    }

    public List<Card> findAll() {
        Iterable<Card> all = cardRepository.findAll();
        return StreamSupport.stream(all.spliterator(), false).collect(Collectors.toList());
    }

    public Card save(Long customerId, Card card) throws CustomerNotFoundException, CardAlreadyExistsException {
        if(cardRepository.findByNumber(card.getNumber()).isPresent()){
            throw new CardAlreadyExistsException(MessageFormat.format("O cartão {0} já foi cadastrado.", card.getNumber()));
        }
        Customer customer = customerRepository.findById(customerId).orElseThrow(() ->
                new CustomerNotFoundException("O cliente informado não foi encontrado"));
        card.setCustomer(customer);
        return cardRepository.save(card);
    }

    public Card activateCard(String number, boolean active) throws CardNotFoundException {
        Card card = getCardByNumber(number);
        card.setActive(active);
        return cardRepository.save(card);
    }

    public Card findByNumber(String number) throws CardNotFoundException {
        return getCardByNumber(number);
    }

    private Card getCardByNumber(String number) throws CardNotFoundException {
        return cardRepository.findByNumber(number).orElseThrow(() ->
                new CardNotFoundException(MessageFormat.format("O cartão com o número {0} não foi encontrado.", number)));
    }
}
