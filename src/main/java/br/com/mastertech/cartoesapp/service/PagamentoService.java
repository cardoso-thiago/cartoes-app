package br.com.mastertech.cartoesapp.service;

import br.com.mastertech.cartoesapp.entity.Cartao;
import br.com.mastertech.cartoesapp.entity.Pagamento;
import br.com.mastertech.cartoesapp.exception.CartaoNotFoundException;
import br.com.mastertech.cartoesapp.repository.CartaoRepository;
import br.com.mastertech.cartoesapp.repository.PagamentoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PagamentoService {
    private final PagamentoRepository pagamentoRepository;
    private final CartaoRepository cartaoRepository;

    public PagamentoService(PagamentoRepository pagamentoRepository, CartaoRepository cartaoRepository) {
        this.pagamentoRepository = pagamentoRepository;
        this.cartaoRepository = cartaoRepository;
    }

    public Pagamento save(Long cartaoId, Pagamento pagamento) throws CartaoNotFoundException {
        Cartao cartao = getCartaoImpl(cartaoId);
        pagamento.setCartao(cartao);
        return pagamentoRepository.save(pagamento);
    }


    public List<Pagamento> getPagamentosPorCartao(Long cartaoId) throws CartaoNotFoundException {
        Cartao cartao = getCartaoImpl(cartaoId);
        return pagamentoRepository.findAllByCartao(cartao);
    }

    private Cartao getCartaoImpl(Long cartaoId) throws CartaoNotFoundException {
        Optional<Cartao> cartao = cartaoRepository.findById(cartaoId);
        if (!cartao.isPresent()) {
            throw new CartaoNotFoundException("O cartão informado não foi encontrado.");
        }
        return cartao.get();
    }
}
