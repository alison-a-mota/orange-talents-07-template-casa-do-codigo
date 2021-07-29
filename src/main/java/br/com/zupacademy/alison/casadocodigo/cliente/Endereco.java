package br.com.zupacademy.alison.casadocodigo.cliente;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Embeddable
public class Endereco {

    @NotBlank
    private String rua;
    @NotNull
    private Integer numero;
    @NotBlank
    private String complemento;
    @NotBlank
    private String cidade;
    @NotBlank
    private String cep;

    public Endereco(String rua, Integer numero, String complemento, String cidade, String cep) {
        this.rua = rua;
        this.numero = numero;
        this.complemento = complemento;
        this.cidade = cidade;
        this.cep = cep;
    }

    @Deprecated
    public Endereco() {
    }
}
