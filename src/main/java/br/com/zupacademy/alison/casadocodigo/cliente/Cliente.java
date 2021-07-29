package br.com.zupacademy.alison.casadocodigo.cliente;

import br.com.zupacademy.alison.casadocodigo.classesCompartilhadas.anotacoes.CpfOuCnpj;
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

    //Endereço
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

    @ManyToOne
    private Estado estado;
    @ManyToOne
    @NotNull
    private Pais pais;

    public Cliente(@NotBlank String nome, @NotBlank String sobreNome, @NotBlank @Email String email,
                   @NotBlank @CpfOuCnpj String documento, @NotBlank String telefone, @NotBlank String rua,
                   @NotNull Integer numero, @NotBlank String complemento, @NotBlank String cidade, @NotBlank String cep,
                   Estado estado, @NotNull Pais pais) {
        this.nome = nome;
        this.sobreNome = sobreNome;
        this.email = email;
        this.documento = documento;
        this.telefone = telefone;
        this.rua = rua;
        this.numero = numero;
        this.complemento = complemento;
        this.cidade = cidade;
        this.cep = cep;
        this.estado = estado;
        this.pais = pais;
    }

    public Long getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(id, cliente.id) && Objects.equals(nome, cliente.nome) && Objects.equals(sobreNome, cliente.sobreNome) && Objects.equals(email, cliente.email) && Objects.equals(documento, cliente.documento) && Objects.equals(telefone, cliente.telefone) && Objects.equals(rua, cliente.rua) && Objects.equals(numero, cliente.numero) && Objects.equals(complemento, cliente.complemento) && Objects.equals(cidade, cliente.cidade) && Objects.equals(cep, cliente.cep) && Objects.equals(estado, cliente.estado) && Objects.equals(pais, cliente.pais);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, sobreNome, email, documento, telefone, rua, numero, complemento, cidade, cep, estado, pais);
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", sobreNome='" + sobreNome + '\'' +
                ", email='" + email + '\'' +
                ", documento='" + documento + '\'' +
                ", telefone='" + telefone + '\'' +
                ", rua='" + rua + '\'' +
                ", numero=" + numero +
                ", complemento='" + complemento + '\'' +
                ", cidade='" + cidade + '\'' +
                ", cep='" + cep + '\'' +
                ", estado=" + estado +
                ", pais=" + pais +
                '}';
    }
}