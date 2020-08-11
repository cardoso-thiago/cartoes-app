package br.com.mastertech.cartoesapp.mapper;

import br.com.mastertech.cartoesapp.dto.*;
import br.com.mastertech.cartoesapp.entity.Card;
import br.com.mastertech.cartoesapp.entity.Customer;
import br.com.mastertech.cartoesapp.entity.Invoice;
import br.com.mastertech.cartoesapp.entity.Payment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DataMapper {
    DataMapper INSTANCE = Mappers.getMapper(DataMapper.class);

    Customer customerRequestToCustomer(CustomerRequest customerRequest);
    CustomerRequest customerToCustomerRequest(Customer customer);
    List<CustomerRequest> customerToCustomerRequest(List<Customer> customer);

    Card cardRequestToCard(CardRequest cardRequest);
    @Mapping(target = "customerId", source = "customer.id")
    CardRequest cardToCardRequest(Card card);
    @Mapping(target = "customerId", source = "customer.id")
    CardResponse cardToCardResponse(Card card);
    List<CardRequest> cardToCardRequest(List<Card> card);

    Payment paymentRequestToPayment(PaymentRequest paymentRequest);
    @Mapping(target = "cardId", source = "card.id")
    PaymentRequest paymentToPaymentRequest(Payment payment);
    List<PaymentRequest> paymentToPaymentRequest(List<Payment> payment);

    InvoiceRequest invoiceToInvoiceRequest(Invoice invoice);
}
