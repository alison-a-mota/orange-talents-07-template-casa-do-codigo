package br.com.zupacademy.alison.casadocodigo.cliente;

import br.com.zupacademy.alison.casadocodigo.estado.EstadoRepository;
import br.com.zupacademy.alison.casadocodigo.pais.PaisRepository;
import org.springframework.http.HttpStatus;
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
    public void novoCliente(@Valid @RequestBody ClienteRequest clienteRequest) {

        validaNecessidadeEstado(clienteRequest);
        Cliente cliente = clienteRequest.toModel(clienteRequest);

    }

    private void validaNecessidadeEstado(ClienteRequest clienteRequest) {

        if (!paisRepository.existsById(clienteRequest.getPaisId())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Esse Estado não foi encontrado.");
        }

        //Verifica se existe algum estado cadastrado para esse país
        if (estadoRepository.existsByPaisId(clienteRequest.getPaisId())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "É necessário informar o Estado.");
        }
        //Verifica se foi passado um Id de estado
        if (clienteRequest.getEstado() != null){
            //Verifica se existe um estado com esse Id
            if(!estadoRepository.existsByIdAndPaisId(clienteRequest.getEstado(), clienteRequest.getPaisId())){
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Esse Estado não foi encontrado.");
            }
        }
    }
}
