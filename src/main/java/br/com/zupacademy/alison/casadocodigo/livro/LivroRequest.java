package br.com.zupacademy.alison.casadocodigo.livro;

import br.com.zupacademy.alison.casadocodigo.autor.AutorRepository;
import br.com.zupacademy.alison.casadocodigo.categoria.CategoriaRepository;
import br.com.zupacademy.alison.casadocodigo.classesCompartilhadas.anotacoes.CampoUnico;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public class LivroRequest {

    @NotNull
    private Long autorId;
    @NotNull
    private Long categoriaId;

    @CampoUnico(fieldName = "titulo", domainClass = Livro.class)
    @NotBlank
    private String titulo;
    @Size(max = 500)
    @NotBlank
    private String resumo;
    private String sumario;
    @DecimalMin("20.00")
    @NotNull
    private BigDecimal preco;
    @Min(100)
    @NotNull
    private Integer quantidadePaginas;
    @CampoUnico(fieldName = "isbnIdentificador", domainClass = Livro.class)
    @NotBlank
    private String isbnIdentificador;
    @Future
    private LocalDate dataPublicacao;

    public String getTitulo() {
        return titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public String getSumario() {
        return sumario;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public Integer getQuantidadePaginas() {
        return quantidadePaginas;
    }

    public String getIsbnIdentificador() {
        return isbnIdentificador;
    }

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

    public Long getAutorId() {
        return autorId;
    }

    public Long getCategoriaId() {
        return categoriaId;
    }

    public Livro toModel(CategoriaRepository categoriaRepository, AutorRepository autorRepository) {
        var autor = autorRepository.findById(this.autorId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Autor não encontrado"));
        var categoria = categoriaRepository.findById(this.categoriaId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Categoria não encontrada"));

        return new Livro(categoria, autor, this.titulo, this.resumo, this.sumario, this.preco, this.quantidadePaginas, this.isbnIdentificador, this.dataPublicacao);
    }
}
