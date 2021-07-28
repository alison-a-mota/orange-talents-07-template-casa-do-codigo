package br.com.zupacademy.alison.casadocodigo.estado;

import br.com.zupacademy.alison.casadocodigo.pais.PaisRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class EstadoRequest {

    @NotBlank
    private String nome;
    @NotNull
    private Long paisId;

    public String getNome() {
        return nome;
    }

    public Long getPaisId() {
        return paisId;
    }

    public Estado toModel(EstadoRepository estadoRepository, PaisRepository paisRepository) {
        //verifica se o Id do país que foi passado existe
        if (!paisRepository.existsById(this.paisId)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "País não encontrado.");

            //verifica se existe o mesmo estado cadastrado para esse país
        } else if (estadoRepository.existsByNomeAndPaisId(this.nome, this.paisId)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Já existe esse estado cadastrado para esse país.");
        }
        return new Estado(paisRepository.findById(this.paisId).get(), this.nome);
    }
}