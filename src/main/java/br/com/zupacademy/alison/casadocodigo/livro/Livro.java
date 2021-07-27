package br.com.zupacademy.alison.casadocodigo.livro;

import br.com.zupacademy.alison.casadocodigo.autor.Autor;
import br.com.zupacademy.alison.casadocodigo.categoria.Categoria;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;

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
    private Double preco;
    @Min(100)
    @NotNull
    private Integer quantidadePaginas;
    @Column(unique = true)
    @NotBlank
    private String lsbnIdentificador;
    @Future
    private LocalDate dataPublicacao;

    public Livro(@NotNull Categoria categoria, @NotNull Autor autor, @NotBlank String titulo, @Size(max = 500) @NotBlank String resumo,
                 String sumario, @DecimalMin("20.00") @NotNull Double preco, @Min(100) @NotNull Integer quantidadePaginas,
                 @NotBlank String lsbnIdentificador, @Future LocalDate dataPublicacao) {
        this.categoria = categoria;
        this.autor = autor;
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.quantidadePaginas = quantidadePaginas;
        this.lsbnIdentificador = lsbnIdentificador;
        this.dataPublicacao = dataPublicacao;
    }


    public String getLsbnIdentificador() {
        return lsbnIdentificador;
    }

    public String getTitulo() {
        return titulo;
    }

    @Deprecated
    public Livro() {
    }

}
