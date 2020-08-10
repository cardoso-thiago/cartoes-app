package br.com.mastertech.cartoesapp.repository;

import br.com.mastertech.cartoesapp.entity.Cartao;
import br.com.mastertech.cartoesapp.entity.Pagamento;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PagamentoRepository extends CrudRepository<Pagamento, Long> {
    List<Pagamento> findAllByCartao(Cartao cartao);
}
