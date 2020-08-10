package br.com.mastertech.cartoesapp.service;

import br.com.mastertech.cartoesapp.entity.Cliente;
import br.com.mastertech.cartoesapp.exception.ClienteNotFoundException;
import br.com.mastertech.cartoesapp.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public List<Cliente> findAll() {
        return StreamSupport.stream(clienteRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public Cliente findById(Long clienteId) throws ClienteNotFoundException {
        return clienteRepository.findById(clienteId).orElseThrow(() -> new ClienteNotFoundException("Cliente não encontrado"));
    }

    public Cliente save(Cliente cliente) {
        return clienteRepository.save(cliente);
    }
}
