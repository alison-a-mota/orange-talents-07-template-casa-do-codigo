package br.com.zupacademy.alison.casadocodigo.autor;

import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
@Validated
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(updatable = false)
    private final LocalDateTime dataCadastro = LocalDateTime.now();

    @NotBlank
    private String nome;
    @NotBlank
    @Column(unique = true)
    @Email
    private String email;
    @NotBlank
    @Size(max = 400)
    private String descricao;

    public Autor(@NotBlank String nome, @NotBlank String email, @NotBlank String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getDescricao() {
        return descricao;
    }

    @Deprecated
    public Autor() {
    }
}
