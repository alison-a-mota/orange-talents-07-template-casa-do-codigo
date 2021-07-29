package br.com.zupacademy.alison.casadocodigo.autor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

//@CreationTimestamp

@RestController
@RequestMapping("/autor")
public class AutorController {

    private final AutorRepository autorRepository;

    public AutorController(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    @PostMapping
    public ResponseEntity<AutorCreatedResponse> cadastrar(@RequestBody @Valid AutorRequest autorRequest){
        var autor = autorRequest.toModel();
        autorRepository.save(autor);

        return ResponseEntity.status(HttpStatus.CREATED).body(new AutorCreatedResponse(autor.getId(), autor.getNome()));
    }
}
