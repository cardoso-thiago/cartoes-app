package br.com.mastertech.cartoesapp.controller;

import br.com.mastertech.cartoesapp.dto.CustomerRequest;
import br.com.mastertech.cartoesapp.entity.Customer;
import br.com.mastertech.cartoesapp.exception.CustomerNotFoundException;
import br.com.mastertech.cartoesapp.mapper.DataMapper;
import br.com.mastertech.cartoesapp.service.CustomerService;
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
@RequestMapping("/cliente")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public ResponseEntity getAllCustomers() {
        List<CustomerRequest> customerRequestList = DataMapper.INSTANCE.customerToCustomerRequest(customerService.findAll());
        return ResponseEntity.ok(customerRequestList);
    }

    @GetMapping("/{id}")
    public ResponseEntity getCustomer(@Valid
                                     @NotNull(message = "O id do cliente não pode ser nulo.")
                                     @Min(value = 1, message = "O id do cliente deve ser um número positivo.")
                                     @PathVariable("id") Long customerId) throws CustomerNotFoundException {
        CustomerRequest customerRequest = DataMapper.INSTANCE.customerToCustomerRequest(customerService.findById(customerId));
        return ResponseEntity.ok(customerRequest);
    }

    @PostMapping
    public ResponseEntity saveCustomer(@RequestBody @Valid CustomerRequest customerRequest) {
        Customer customer = DataMapper.INSTANCE.customerRequestToCustomer(customerRequest);
        CustomerRequest savedCustomerRequest = DataMapper.INSTANCE.customerToCustomerRequest(customerService.save(customer));
        return ResponseEntity.created(URI.create("")).body(savedCustomerRequest);
    }
}
