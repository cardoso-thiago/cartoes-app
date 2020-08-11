package br.com.mastertech.cartoesapp.repository;

import br.com.mastertech.cartoesapp.entity.Card;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CardRepository extends CrudRepository<Card, Long> {
    Optional<Card> findByNumber(String number);

    Optional<Card> findByIdAndCustomerId(Long cardId, Long customerId);
}
