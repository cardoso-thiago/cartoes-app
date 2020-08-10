package br.com.mastertech.cartoesapp.controller;

import br.com.mastertech.cartoesapp.dto.ClienteDto;
import br.com.mastertech.cartoesapp.entity.Cliente;
import br.com.mastertech.cartoesapp.exception.ClienteNotFoundException;
import br.com.mastertech.cartoesapp.mapper.DataMapper;
import br.com.mastertech.cartoesapp.service.ClienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.net.URI;
import java.util.List;

@RestController
@Validated
@RequestMapping("/cliente")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    public ResponseEntity getAllClientes() {
        List<ClienteDto> clienteDtoList = DataMapper.INSTANCE.clienteToClienteDto(clienteService.findAll());
        return ResponseEntity.ok(clienteDtoList);
    }

    @GetMapping("/{id}")
    public ResponseEntity getCliente(@Valid
                                     @Min(value = 1, message = "O id do cliente deve ser um número positivo.")
                                     @PathVariable("id") Long clienteId) throws ClienteNotFoundException {
        ClienteDto clienteDto = DataMapper.INSTANCE.clienteToClienteDto(clienteService.findById(clienteId));
        return ResponseEntity.ok(clienteDto);
    }

    @PostMapping
    public ResponseEntity saveCliente(@RequestBody @Valid ClienteDto clienteDto) {
        Cliente cliente = DataMapper.INSTANCE.clienteDtoToCliente(clienteDto);
        ClienteDto savedClienteDto = DataMapper.INSTANCE.clienteToClienteDto(clienteService.save(cliente));
        return ResponseEntity.created(URI.create("")).body(savedClienteDto);
    }
}
