package br.com.zupacademy.alison.casadocodigo.pais;

import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Objects;

@Entity
@Validated
public class Pais {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Column(unique = true)
    private String nome;

    public Pais(@NotBlank String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    @Deprecated
    public Pais() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pais pais = (Pais) o;
        return Objects.equals(id, pais.id) && Objects.equals(nome, pais.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome);
    }
}
