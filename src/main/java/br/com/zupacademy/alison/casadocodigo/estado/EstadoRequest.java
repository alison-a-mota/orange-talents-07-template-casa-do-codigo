package br.com.zupacademy.alison.casadocodigo.estado;

import br.com.zupacademy.alison.casadocodigo.compartilhado.anotacoes.ExistsById;
import br.com.zupacademy.alison.casadocodigo.pais.Pais;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class EstadoRequest {

    @NotBlank
    private String nome;
    @NotNull
    @ExistsById(fieldName = "id", domainClass = Pais.class)
    private Long paisId;

    public String getNome() {
        return nome;
    }

    public Long getPaisId() {
        return paisId;
    }

    public Estado toModel(Pais pais) {
        return new Estado(pais, this.nome);
    }
}