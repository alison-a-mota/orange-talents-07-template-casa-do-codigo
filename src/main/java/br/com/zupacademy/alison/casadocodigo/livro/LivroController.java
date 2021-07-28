package br.com.zupacademy.alison.casadocodigo.livro;

import br.com.zupacademy.alison.casadocodigo.autor.AutorRepository;
import br.com.zupacademy.alison.casadocodigo.autor.AutorSiteResponse;
import br.com.zupacademy.alison.casadocodigo.categoria.CategoriaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

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
    public ResponseEntity<String> novoLivro(@RequestBody @Valid LivroRequest livroRequest) {

        var livro = livroRequest.toModel(categoriaRepository, autorRepository);
        livroRepository.save(livro);

        return ResponseEntity.status(HttpStatus.CREATED).body("Livro cadastrado.");
    }

    @GetMapping
    public List<LivroListaTodosResponse> listaTodosLivros() {

        List<Livro> livros = (List<Livro>) livroRepository.findAll();
        return LivroListaTodosResponse.toModel(livros);
    }

    @GetMapping("/{id}")
    public List<Object> detalhaLivro(@PathVariable Long id) {

        var livro = livroRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus
                .NOT_FOUND, "Livro não encontrado"));
        var autor = autorRepository.findById(livro.getAutor().getId()).get();

        List<Object> resposta = new ArrayList<Object>();
        resposta.add(LivroDetalhadoSiteResponse.conversorResponse(livro));
        resposta.add(AutorSiteResponse.conversorResponse(autor));

        return resposta;
    }
}