package br.com.zupacademy.alison.casadocodigo.cliente;

import br.com.zupacademy.alison.casadocodigo.compartilhado.anotacoes.CpfOuCnpj;
import br.com.zupacademy.alison.casadocodigo.estado.Estado;
import br.com.zupacademy.alison.casadocodigo.pais.Pais;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@Validated
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String nome;
    @NotBlank
    private String sobreNome;
    @NotBlank
    @Email
    @Column(unique = true)
    private String email;
    @NotBlank
    @CpfOuCnpj
    @Column(unique = true)
    private String documento;
    @NotBlank
    private String telefone;

    @Embedded
    private Endereco endereco;

    @ManyToOne
    private Estado estado;
    @ManyToOne
    @NotNull
    private Pais pais;

    public Cliente(@NotBlank String nome, @NotBlank String sobreNome, @NotBlank @Email String email,
                   @NotBlank @CpfOuCnpj String documento, @NotBlank String telefone, @NotNull Endereco endereco,
                   Estado estado, @NotNull Pais pais) {
        this.nome = nome;
        this.sobreNome = sobreNome;
        this.email = email;
        this.documento = documento;
        this.telefone = telefone;
        this.endereco = endereco;
        this.estado = estado;
        this.pais = pais;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    @Deprecated
    public Cliente() {
    }
}