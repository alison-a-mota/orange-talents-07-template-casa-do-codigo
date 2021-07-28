package br.com.zupacademy.alison.casadocodigo.pais;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/pais")
public class PaisController {

    private final PaisRepository paisRepository;

    public PaisController(PaisRepository paisRepository) {
        this.paisRepository = paisRepository;
    }

    @PostMapping
    public ResponseEntity<String> novoPais(@Valid @RequestBody PaisRequest paisRequest) {
        Pais pais = paisRequest.toModel();
        paisRepository.save(pais);

        return ResponseEntity.status(HttpStatus.CREATED).body("País '" + pais.getNome() + "' criado.");
    }

}
