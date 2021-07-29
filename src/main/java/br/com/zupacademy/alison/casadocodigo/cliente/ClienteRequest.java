package br.com.zupacademy.alison.casadocodigo.cliente;

import br.com.zupacademy.alison.casadocodigo.classesCompartilhadas.anotacoes.CampoUnico;
import br.com.zupacademy.alison.casadocodigo.classesCompartilhadas.anotacoes.CpfOuCnpj;
import br.com.zupacademy.alison.casadocodigo.classesCompartilhadas.anotacoes.ExistsById;
import br.com.zupacademy.alison.casadocodigo.estado.Estado;
import br.com.zupacademy.alison.casadocodigo.estado.EstadoRepository;
import br.com.zupacademy.alison.casadocodigo.pais.Pais;
import br.com.zupacademy.alison.casadocodigo.pais.PaisRepository;

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

    private Long estadoId;
    @NotNull
    @ExistsById(fieldName = "id", domainClass = Pais.class)
    private Long paisId;

    public Cliente toModel(ClienteRequest clienteRequest, PaisRepository paisRepository, EstadoRepository estadoRepository) {

        Pais pais = paisRepository.findById(this.paisId).get();
        Estado estado = null;

        if(this.estadoId != null) {
            estado = estadoRepository.findById(this.estadoId).get();
            return new Cliente(nome, sobreNome, email, documento, telefone, rua, numero, complemento, cidade, cep, estado, pais);
        } return new Cliente(nome, sobreNome, email, documento, telefone, rua, numero, complemento, cidade, cep, null, pais);
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

    public Long getEstadoId() {
        return estadoId;
    }

    public Long getPaisId() {
        return paisId;
    }
}
