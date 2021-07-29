package br.com.zupacademy.alison.casadocodigo.estado;

public class EstadoCreatedResponse {

    private final Long id;
    private final String nome;

    public EstadoCreatedResponse(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}
