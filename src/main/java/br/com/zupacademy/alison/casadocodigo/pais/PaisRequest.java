package br.com.zupacademy.alison.casadocodigo.pais;

import br.com.zupacademy.alison.casadocodigo.classesCompartilhadas.anotacoes.CampoUnico;

import javax.validation.constraints.NotBlank;

public class PaisRequest {

    @NotBlank
    @CampoUnico(fieldName = "nome", domainClass = Pais.class)
    private String nome;

    public String getNome() {
        return nome;
    }

    public Pais toModel() {
        return new Pais(nome);
    }
}
