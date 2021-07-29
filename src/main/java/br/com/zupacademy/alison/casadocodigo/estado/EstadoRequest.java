package br.com.zupacademy.alison.casadocodigo.estado;

import br.com.zupacademy.alison.casadocodigo.classesCompartilhadas.anotacoes.ExistsById;
import br.com.zupacademy.alison.casadocodigo.pais.Pais;
import br.com.zupacademy.alison.casadocodigo.pais.PaisRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

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

    public Estado toModel(EstadoRepository estadoRepository, PaisRepository paisRepository) {

        if (estadoRepository.existsByNomeAndPaisId(this.nome, this.paisId)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Já existe esse estado cadastrado para esse país.");
        }
        return new Estado(paisRepository.findById(this.paisId).get(), this.nome);
    }
}