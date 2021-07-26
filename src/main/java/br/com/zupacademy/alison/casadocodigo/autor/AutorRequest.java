package br.com.zupacademy.alison.casadocodigo.autor;

import br.com.zupacademy.alison.casadocodigo.anotacoes.CampoUnico;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class AutorRequest {

    @NotBlank
    private String nome;
    @NotBlank
    @CampoUnico(fieldName = "email", domainClass = Autor.class, message = "E-mail já cadastrado.")
    @Email
    private String email;
    @NotBlank
    @Size(max = 400)
    private String descricao;

    public Autor toModel() {
        return new Autor(nome, email, descricao);
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
    public AutorRequest() {
    }
}
