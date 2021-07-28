package br.com.zupacademy.alison.casadocodigo.estado;

import br.com.zupacademy.alison.casadocodigo.pais.PaisRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity<String> novoEstado(@RequestBody @Valid EstadoRequest estadoRequest) {
        Estado estado = estadoRequest.toModel(estadoRepository, paisRepository);
        estadoRepository.save(estado);
        return ResponseEntity.status(HttpStatus.CREATED).body("Estado '" + estado.getNome() + "' cadastrado.");
    }
}
