package br.com.zupacademy.alison.casadocodigo.livro;

import br.com.zupacademy.alison.casadocodigo.autor.Autor;
import br.com.zupacademy.alison.casadocodigo.categoria.Categoria;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Validated
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @NotNull
    private Categoria categoria;
    @ManyToOne
    @NotNull
    private Autor autor;

    @Column(unique = true)
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
    @Column(unique = true)
    @NotBlank
    private String isbnIdentificador;
    @Future
    private LocalDate dataPublicacao;

    public Livro(@NotNull Categoria categoria, @NotNull Autor autor, @NotBlank String titulo, @Size(max = 500) @NotBlank String resumo,
                 String sumario, @DecimalMin("20.00") @NotNull BigDecimal preco, @Min(100) @NotNull Integer quantidadePaginas,
                 @NotBlank String isbnIdentificador, @Future LocalDate dataPublicacao) {
        this.categoria = categoria;
        this.autor = autor;
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.quantidadePaginas = quantidadePaginas;
        this.isbnIdentificador = isbnIdentificador;
        this.dataPublicacao = dataPublicacao;
    }

    public String getIsbnIdentificador() {
        return isbnIdentificador;
    }

    public String getTitulo() {
        return titulo;
    }

    public Long getId() {
        return id;
    }

    public Autor getAutor() {
        return autor;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Livro livro = (Livro) o;
        return Objects.equals(id, livro.id) && Objects.equals(categoria, livro.categoria) && Objects.equals(autor, livro.autor) && Objects.equals(titulo, livro.titulo) && Objects.equals(resumo, livro.resumo) && Objects.equals(sumario, livro.sumario) && Objects.equals(preco, livro.preco) && Objects.equals(quantidadePaginas, livro.quantidadePaginas) && Objects.equals(isbnIdentificador, livro.isbnIdentificador) && Objects.equals(dataPublicacao, livro.dataPublicacao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, categoria, autor, titulo, resumo, sumario, preco, quantidadePaginas, isbnIdentificador, dataPublicacao);
    }

    @Deprecated
    public Livro() {
    }
}
