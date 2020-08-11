package br.com.mastertech.cartoesapp.repository;

import br.com.mastertech.cartoesapp.entity.Card;
import br.com.mastertech.cartoesapp.entity.Payment;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PaymentRepository extends CrudRepository<Payment, Long> {
    List<Payment> findAllByCard(Card card);
}
