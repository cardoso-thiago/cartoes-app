package br.com.mastertech.cartoesapp.service;

import br.com.mastertech.cartoesapp.entity.Cartao;
import br.com.mastertech.cartoesapp.entity.Pagamento;
import br.com.mastertech.cartoesapp.exception.CartaoDesativadoException;
import br.com.mastertech.cartoesapp.exception.CartaoExpiradoException;
import br.com.mastertech.cartoesapp.exception.CartaoNotFoundException;
import br.com.mastertech.cartoesapp.repository.CartaoRepository;
import br.com.mastertech.cartoesapp.repository.PagamentoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PagamentoService {
    private final PagamentoRepository pagamentoRepository;
    private final CartaoRepository cartaoRepository;

    public PagamentoService(PagamentoRepository pagamentoRepository, CartaoRepository cartaoRepository) {
        this.pagamentoRepository = pagamentoRepository;
        this.cartaoRepository = cartaoRepository;
    }

    public Pagamento save(Long cartaoId, Pagamento pagamento) throws CartaoNotFoundException, CartaoExpiradoException, CartaoDesativadoException {
        Cartao cartao = getCartaoImpl(cartaoId);
        if(!cartao.isAtivo()) {
            throw new CartaoDesativadoException("Não é possível realizar o pagamento, o cartão está desativado.");
        }
        if(cartao.isExpirado()) {
            throw new CartaoExpiradoException("Não é possível realizar o pagamento, o cartão está expirado.");
        }
        pagamento.setCartao(cartao);
        return pagamentoRepository.save(pagamento);
    }

    public List<Pagamento> getPagamentosPorCartao(Long cartaoId) throws CartaoNotFoundException {
        Cartao cartao = getCartaoImpl(cartaoId);
        return pagamentoRepository.findAllByCartao(cartao);
    }

    private Cartao getCartaoImpl(Long cartaoId) throws CartaoNotFoundException {
        return cartaoRepository.findById(cartaoId).orElseThrow(() -> new CartaoNotFoundException("O cartão informado não foi encontrado."));
    }
}
