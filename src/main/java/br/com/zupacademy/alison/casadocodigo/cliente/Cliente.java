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
}