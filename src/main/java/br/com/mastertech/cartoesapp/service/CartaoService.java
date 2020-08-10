package br.com.mastertech.cartoesapp.service;

import br.com.mastertech.cartoesapp.entity.Cartao;
import br.com.mastertech.cartoesapp.entity.Cliente;
import br.com.mastertech.cartoesapp.exception.CartaoAlreadyExistsException;
import br.com.mastertech.cartoesapp.exception.CartaoNotFoundException;
import br.com.mastertech.cartoesapp.exception.ClienteNotFoundException;
import br.com.mastertech.cartoesapp.repository.CartaoRepository;
import br.com.mastertech.cartoesapp.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class CartaoService {
    private final CartaoRepository cartaoRepository;
    private final ClienteRepository clienteRepository;

    public CartaoService(CartaoRepository cartaoRepository, ClienteRepository clienteRepository) {
        this.cartaoRepository = cartaoRepository;
        this.clienteRepository = clienteRepository;
    }

    public List<Cartao> findAll() {
        Iterable<Cartao> all = cartaoRepository.findAll();
        return StreamSupport.stream(all.spliterator(), false).collect(Collectors.toList());
    }

    public Cartao save(Long clienteId, Cartao cartao) throws ClienteNotFoundException, CartaoAlreadyExistsException {
        if(cartaoRepository.findByNumero(cartao.getNumero()).isPresent()){
            throw new CartaoAlreadyExistsException(MessageFormat.format("O cartão {0} já foi cadastrado.", cartao.getNumero()));
        }
        Cliente cliente = clienteRepository.findById(clienteId).orElseThrow(() ->
                new ClienteNotFoundException("O cliente informado não foi encontrado"));
        cartao.setCliente(cliente);
        return cartaoRepository.save(cartao);
    }

    public Cartao ativacaoCartao(String numeroCartao, boolean ativo) throws CartaoNotFoundException {
        Cartao cartao = getCartaoByNumeroImpl(numeroCartao);
        cartao.setAtivo(ativo);
        return cartaoRepository.save(cartao);
    }

    public Cartao findByNumero(String numeroCartao) throws CartaoNotFoundException {
        return getCartaoByNumeroImpl(numeroCartao);
    }

    private Cartao getCartaoByNumeroImpl(String numeroCartao) throws CartaoNotFoundException {
        return cartaoRepository.findByNumero(numeroCartao).orElseThrow(() ->
                new CartaoNotFoundException(MessageFormat.format("O cartão com o número {0} não foi encontrado.", numeroCartao)));
    }
}
