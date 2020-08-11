package br.com.mastertech.cartoesapp.repository;

import br.com.mastertech.cartoesapp.entity.Cartao;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CartaoRepository extends CrudRepository<Cartao, Long> {
    Optional<Cartao> findByNumero(String numeroCartao);

    Optional<Cartao> findByIdAndClienteId(Long cartaoId, Long clienteId);
}
