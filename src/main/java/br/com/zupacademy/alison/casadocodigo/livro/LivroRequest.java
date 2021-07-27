package br.com.zupacademy.alison.casadocodigo.livro;

import br.com.zupacademy.alison.casadocodigo.autor.Autor;
import br.com.zupacademy.alison.casadocodigo.categoria.Categoria;
import br.com.zupacademy.alison.casadocodigo.classesCompartilhadas.anotacoes.CampoUnico;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public class LivroRequest {

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
    @CampoUnico(fieldName = "lsbnIdentificador", domainClass = Livro.class)
    @NotBlank
    private String lsbnIdentificador;
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

    public String getLsbnIdentificador() {
        return lsbnIdentificador;
    }

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

    public Livro toModel(Autor autor, Categoria categoria) {
        return new Livro(categoria, autor, this.titulo, this.resumo, this.sumario, this.preco, this.quantidadePaginas, this.lsbnIdentificador, this.dataPublicacao);
    }
}
