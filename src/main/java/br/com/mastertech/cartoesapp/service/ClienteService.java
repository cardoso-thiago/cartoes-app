package br.com.mastertech.cartoesapp.service;

import br.com.mastertech.cartoesapp.entity.Cliente;
import br.com.mastertech.cartoesapp.exception.ClienteNotFoundException;
import br.com.mastertech.cartoesapp.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public List<Cliente> findAll() {
        Iterable<Cliente> all = clienteRepository.findAll();
        return StreamSupport.stream(all.spliterator(), false).collect(Collectors.toList());
    }

    public Cliente findById(Long clienteId) throws ClienteNotFoundException {
        Optional<Cliente> cliente = clienteRepository.findById(clienteId);
        if (!cliente.isPresent()) {
            throw new ClienteNotFoundException("Cliente não encontrado");
        }
        return cliente.get();
    }

    public Cliente save(Cliente cliente) {
        return clienteRepository.save(cliente);
    }
}
