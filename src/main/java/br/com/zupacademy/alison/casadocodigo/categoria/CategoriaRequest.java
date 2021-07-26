package br.com.zupacademy.alison.casadocodigo.categoria;

import br.com.zupacademy.alison.casadocodigo.classesCompartilhadas.anotacoes.CampoUnico;

import javax.validation.constraints.NotBlank;

public class CategoriaRequest {

    @NotBlank
    @CampoUnico(fieldName = "nome", domainClass = Categoria.class, message = "Já existe uma categoria cadastrada com esse nome.")
    private String nome;

    public Categoria toModel() {
        return new Categoria(nome);
    }

    public String getNome() {
        return nome;
    }
}
