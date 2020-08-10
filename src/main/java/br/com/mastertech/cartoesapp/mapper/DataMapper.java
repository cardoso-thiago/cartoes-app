package br.com.mastertech.cartoesapp.mapper;

import br.com.mastertech.cartoesapp.dto.CartaoDto;
import br.com.mastertech.cartoesapp.dto.CartaoSemEstadoDto;
import br.com.mastertech.cartoesapp.dto.ClienteDto;
import br.com.mastertech.cartoesapp.dto.PagamentoDto;
import br.com.mastertech.cartoesapp.entity.Cartao;
import br.com.mastertech.cartoesapp.entity.Cliente;
import br.com.mastertech.cartoesapp.entity.Pagamento;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DataMapper {
    DataMapper INSTANCE = Mappers.getMapper(DataMapper.class);

    Cliente clienteDtoToCliente(ClienteDto clienteDto);
    ClienteDto clienteToClienteDto(Cliente cliente);
    List<ClienteDto> clienteToClienteDto(List<Cliente> cliente);

    Cartao cartaoDtoToCartao(CartaoDto cartaoDto);
    @Mapping(target = "clienteId", source = "cliente.id")
    CartaoDto cartaoToCartaoDto(Cartao cartao);
    @Mapping(target = "clienteId", source = "cliente.id")
    CartaoSemEstadoDto cartaoToCartaoSemEstadoDto(Cartao cartao);
    List<CartaoDto> cartaoToCartaoDto(List<Cartao> cartao);

    Pagamento pagamentoDtoToPagamento(PagamentoDto pagamentoDto);
    @Mapping(target = "cartaoId", source = "cartao.id")
    PagamentoDto pagamentoToPagamentoDto(Pagamento pagamento);
    List<PagamentoDto> pagamentoToPagamentoDto(List<Pagamento> pagamento);
}
