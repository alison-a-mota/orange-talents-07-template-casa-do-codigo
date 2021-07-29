package br.com.zupacademy.alison.casadocodigo.estado;

import br.com.zupacademy.alison.casadocodigo.pais.Pais;
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
@RequestMapping("/estado")
public class EstadoController {

    private final EstadoRepository estadoRepository;
    private final PaisRepository paisRepository;

    public EstadoController(EstadoRepository estadoRepository, PaisRepository paisRepository) {
        this.estadoRepository = estadoRepository;
        this.paisRepository = paisRepository;
    }

    @PostMapping
    public ResponseEntity<EstadoCreatedResponse> cadastrar(@RequestBody @Valid EstadoRequest estadoRequest) {

        if (estadoRepository.existsByNomeAndPaisId(estadoRequest.getNome(), estadoRequest.getPaisId())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Já existe esse estado cadastrado para esse país.");
        }

        Pais pais = paisRepository.findById(estadoRequest.getPaisId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "País não encontrado."));

        Estado estado = estadoRequest.toModel(pais);
        estadoRepository.save(estado);

        return ResponseEntity.status(HttpStatus.CREATED).body(new EstadoCreatedResponse(estado.getId(), estado.getNome()));
    }
}
