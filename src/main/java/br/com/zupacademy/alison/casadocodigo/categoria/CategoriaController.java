package br.com.zupacademy.alison.casadocodigo.categoria;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    private final CategoriaRepository categoriaRepository;

    public CategoriaController(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @PostMapping
    public ResponseEntity<CategoriaCreatedResponse> cadastrar(@RequestBody @Valid CategoriaRequest categoriaRequest) {
        Categoria categoria = categoriaRequest.toModel();
        categoriaRepository.save(categoria);

        return ResponseEntity.status(HttpStatus.CREATED).body(new CategoriaCreatedResponse(categoria.getId(), categoria.getNome()));
    }
}
