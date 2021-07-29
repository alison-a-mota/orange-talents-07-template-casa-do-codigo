package br.com.zupacademy.alison.casadocodigo.cliente;

import br.com.zupacademy.alison.casadocodigo.classesCompartilhadas.anotacoes.CampoUnico;
import br.com.zupacademy.alison.casadocodigo.classesCompartilhadas.anotacoes.CpfOuCnpj;
import br.com.zupacademy.alison.casadocodigo.classesCompartilhadas.anotacoes.ExistsById;
import br.com.zupacademy.alison.casadocodigo.pais.Pais;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ClienteRequest {

    @NotBlank
    private String nome;
    @NotBlank
    private String sobreNome;
    @NotBlank
    @Email
    @CampoUnico(fieldName = "email", domainClass = Cliente.class)
    private String email;
    @NotBlank
    @CpfOuCnpj
    @CampoUnico(fieldName = "documento", domainClass = Cliente.class)
    private String documento;
    @NotBlank
    private String telefone;

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

    private Long estado;
    @NotNull
    @ExistsById(fieldName = "id", domainClass = Pais.class)
    private Long paisId;

    public Cliente toModel(ClienteRequest clienteRequest) {
        return new Cliente();
    }

    public String getNome() {
        return nome;
    }

    public String getSobreNome() {
        return sobreNome;
    }

    public String getEmail() {
        return email;
    }

    public String getDocumento() {
        return documento;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getRua() {
        return rua;
    }

    public Integer getNumero() {
        return numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getCidade() {
        return cidade;
    }

    public String getCep() {
        return cep;
    }

    public Long getEstado() {
        return estado;
    }

    public Long getPaisId() {
        return paisId;
    }
}
