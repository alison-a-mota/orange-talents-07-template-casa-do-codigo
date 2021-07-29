package br.com.zupacademy.alison.casadocodigo.livro;

import br.com.zupacademy.alison.casadocodigo.autor.AutorRepository;
import br.com.zupacademy.alison.casadocodigo.categoria.CategoriaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/livro")
public class LivroController {

    private final LivroRepository livroRepository;
    private final AutorRepository autorRepository;
    private final CategoriaRepository categoriaRepository;

    public LivroController(LivroRepository livroRepository, AutorRepository autorRepository,
                           CategoriaRepository categoriaRepository) {
        this.livroRepository = livroRepository;
        this.autorRepository = autorRepository;
        this.categoriaRepository = categoriaRepository;
    }

    @PostMapping
    public ResponseEntity<LivroCreatedResponse> cadastrar(@RequestBody @Valid LivroRequest livroRequest) {

        var livro = livroRequest.toModel(categoriaRepository, autorRepository);
        livroRepository.save(livro);

        return ResponseEntity.status(HttpStatus.CREATED).body(new LivroCreatedResponse(livro.getId(), livro.getTitulo()));
    }

    @GetMapping
    public List<LivroListaTodosResponse> listaTodos() {

        var livros = livroRepository.findAll();
        return livros.stream().map(LivroListaTodosResponse::new).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public LivroDetalhadoSiteResponse detalha(@PathVariable Long id) {

        var livro = livroRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus
                .NOT_FOUND, "Livro não encontrado"));
        var autor = autorRepository.findById(livro.getAutor().getId()).orElseThrow(() -> new ResponseStatusException(HttpStatus
                .NOT_FOUND, "Autor não encontrado"));

        return new LivroDetalhadoSiteResponse(livro, autor);
    }
}