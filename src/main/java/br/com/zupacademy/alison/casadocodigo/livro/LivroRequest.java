package br.com.zupacademy.alison.casadocodigo.livro;

import br.com.zupacademy.alison.casadocodigo.autor.Autor;
import br.com.zupacademy.alison.casadocodigo.autor.AutorRepository;
import br.com.zupacademy.alison.casadocodigo.categoria.Categoria;
import br.com.zupacademy.alison.casadocodigo.categoria.CategoriaRepository;
import br.com.zupacademy.alison.casadocodigo.compartilhado.anotacoes.CampoUnico;
import br.com.zupacademy.alison.casadocodigo.compartilhado.anotacoes.ExistsById;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public class LivroRequest {

    @NotNull
    @ExistsById(fieldName = "id", domainClass = Autor.class)
    private Long autorId;
    @NotNull
    @ExistsById(fieldName = "id", domainClass = Categoria.class)
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
        var autor = autorRepository.findById(this.autorId).get();
        var categoria = categoriaRepository.findById(this.categoriaId).get();

        return new Livro(categoria, autor, this.titulo, this.resumo, this.sumario, this.preco, this.quantidadePaginas, this.isbnIdentificador, this.dataPublicacao);
    }
}
