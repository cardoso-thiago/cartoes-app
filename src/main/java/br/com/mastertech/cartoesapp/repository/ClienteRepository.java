package br.com.mastertech.cartoesapp.repository;

import br.com.mastertech.cartoesapp.entity.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface ClienteRepository extends CrudRepository<Cliente, Long> {}
