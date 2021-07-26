package br.com.zupacademy.alison.casadocodigo.autor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/autor")
public class AutorController {

    private AutorRepository autorRepository;

    public AutorController(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    @PostMapping
    public ResponseEntity<String> novoAutor(@RequestBody @Valid AutorRequest autorRequest){
        Autor autor = autorRequest.toModel();
        autorRepository.save(autor);

        return ResponseEntity.status(HttpStatus.CREATED).body("Autor " + autor.getNome() + " cadastrado.");
    }
}
