package br.com.zupacademy.alison.casadocodigo.cliente;

import br.com.zupacademy.alison.casadocodigo.estado.EstadoRepository;
import br.com.zupacademy.alison.casadocodigo.pais.PaisRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    private final ClienteRepository clienteRepository;
    private final EstadoRepository estadoRepository;
    private final PaisRepository paisRepository;

    public ClienteController(ClienteRepository clienteRepository, EstadoRepository estadoRepository, PaisRepository paisRepository) {
        this.clienteRepository = clienteRepository;
        this.estadoRepository = estadoRepository;
        this.paisRepository = paisRepository;
    }

    @PostMapping
    public ResponseEntity<ClienteCreatedResponse> cadastrar(@Valid @RequestBody ClienteRequest clienteRequest) {

        validaNecessidadeDeEstado(clienteRequest);
        Cliente cliente = clienteRequest.toModel(paisRepository, estadoRepository);
        clienteRepository.save(cliente);

        return ResponseEntity.status(HttpStatus.CREATED).body(new ClienteCreatedResponse(cliente.getId(), cliente.getNome()));
    }

    private void validaNecessidadeDeEstado(ClienteRequest clienteRequest) {

        //Verifica se foi passado um Id de estado. Se não, valida se o País tem estado cadastrado.
        if (clienteRequest.getEstadoId() == null) {
            if (estadoRepository.existsByPaisId(clienteRequest.getPaisId())) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "É necessário informar o Estado.");
            }
        } else if (!estadoRepository.existsByIdAndPaisId(clienteRequest.getEstadoId(), clienteRequest.getPaisId())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Esse Estado não foi encontrado.");
        }
    }
}
