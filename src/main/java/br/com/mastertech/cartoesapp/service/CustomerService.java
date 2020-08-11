package br.com.mastertech.cartoesapp.service;

import br.com.mastertech.cartoesapp.entity.Customer;
import br.com.mastertech.cartoesapp.exception.CustomerNotFoundException;
import br.com.mastertech.cartoesapp.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> findAll() {
        return StreamSupport.stream(customerRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public Customer findById(Long customerId) throws CustomerNotFoundException {
        return customerRepository.findById(customerId).orElseThrow(() -> new CustomerNotFoundException("Cliente não encontrado"));
    }

    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }
}
