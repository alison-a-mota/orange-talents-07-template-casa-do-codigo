package br.com.zupacademy.alison.casadocodigo.autor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String nome;
    @NotBlank
    @Column(unique = true)
    @Email
    private String email;
    @NotBlank
    @Size(max = 400)
    private String descricao;
    @Column(updatable = false)
    private final LocalDateTime dataCadastro = LocalDateTime.now();

    public Autor(String nome, String email, String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
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
