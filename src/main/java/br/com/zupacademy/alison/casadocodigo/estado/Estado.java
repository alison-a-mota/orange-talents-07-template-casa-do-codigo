package br.com.zupacademy.alison.casadocodigo.estado;

import br.com.zupacademy.alison.casadocodigo.pais.Pais;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@Validated
public class Estado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String nome;
    @NotNull
    @ManyToOne
    private Pais pais;

    public Estado(@NotNull Pais pais, @NotBlank String nome) {
        this.nome = nome;
        this.pais = pais;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Estado estado = (Estado) o;
        return Objects.equals(id, estado.id) && Objects.equals(nome, estado.nome) && Objects.equals(pais, estado.pais);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, pais);
    }
}