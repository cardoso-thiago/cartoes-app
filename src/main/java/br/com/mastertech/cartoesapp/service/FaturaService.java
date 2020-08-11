package br.com.mastertech.cartoesapp.service;

import br.com.mastertech.cartoesapp.entity.Cartao;
import br.com.mastertech.cartoesapp.entity.Cliente;
import br.com.mastertech.cartoesapp.entity.Fatura;
import br.com.mastertech.cartoesapp.entity.Pagamento;
import br.com.mastertech.cartoesapp.entity.builder.FaturaBuilder;
import br.com.mastertech.cartoesapp.exception.CartaoNotFoundException;
import br.com.mastertech.cartoesapp.exception.ClienteNotFoundException;
import br.com.mastertech.cartoesapp.repository.CartaoRepository;
import br.com.mastertech.cartoesapp.repository.ClienteRepository;
import br.com.mastertech.cartoesapp.repository.FaturaRepository;
import br.com.mastertech.cartoesapp.repository.PagamentoRepository;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.Date;
import java.util.List;

@Service
public class FaturaService {

    private final CartaoRepository cartaoRepository;
    private final ClienteRepository clienteRepository;
    private final FaturaRepository faturaRepository;
    private final PagamentoRepository pagamentoRepository;

    public FaturaService(CartaoRepository cartaoRepository, ClienteRepository clienteRepository, FaturaRepository faturaRepository, PagamentoRepository pagamentoRepository) {
        this.cartaoRepository = cartaoRepository;
        this.clienteRepository = clienteRepository;
        this.faturaRepository = faturaRepository;
        this.pagamentoRepository = pagamentoRepository;
    }

    public List<Pagamento> getFatura(Long clienteId, Long cartaoId) throws CartaoNotFoundException, ClienteNotFoundException {
        return getCartao(clienteId, cartaoId).getPagamentos();
    }

    public Fatura pagar(Long clienteId, Long cartaoId) throws ClienteNotFoundException, CartaoNotFoundException {
        Cartao cartao = getCartao(clienteId, cartaoId);
        List<Pagamento> pagamentos = cartao.getPagamentos();

        double totalFatura = pagamentos.stream().mapToDouble(Pagamento::getValor).sum();
        Fatura fatura = FaturaBuilder.aFatura().cartao(cartao).valorPago(totalFatura).pagoEm(new Date()).build();

        pagamentoRepository.deleteAll(pagamentos);

        return faturaRepository.save(fatura);
    }

    public void expirarCartao(Long clienteId, Long cartaoId) throws ClienteNotFoundException, CartaoNotFoundException {
        Cartao cartao = getCartao(clienteId, cartaoId);
        cartao.setExpirado(Boolean.TRUE);
        cartaoRepository.save(cartao);
    }

    private Cartao getCartao(Long clienteId, Long cartaoId) throws ClienteNotFoundException, CartaoNotFoundException {
        Cliente cliente = clienteRepository.findById(clienteId).orElseThrow(() -> new ClienteNotFoundException("Cliente não encontrado."));

        Cartao cartao = cartaoRepository.findByIdAndClienteId(cartaoId, clienteId).orElseThrow(()
                -> new CartaoNotFoundException(MessageFormat.format("Cartão não encontrado para o cliente {0}",
                cliente.getNome())));

        return cartao;
    }
}
