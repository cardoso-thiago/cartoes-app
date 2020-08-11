package br.com.mastertech.cartoesapp.repository;

import br.com.mastertech.cartoesapp.entity.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {}
