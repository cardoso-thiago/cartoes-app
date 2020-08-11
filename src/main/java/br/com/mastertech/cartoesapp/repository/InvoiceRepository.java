package br.com.mastertech.cartoesapp.repository;

import br.com.mastertech.cartoesapp.entity.Invoice;
import org.springframework.data.repository.CrudRepository;

public interface InvoiceRepository extends CrudRepository<Invoice, Long> {}
