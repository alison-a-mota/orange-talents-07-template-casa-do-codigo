package br.com.zupacademy.alison.casadocodigo.cliente;

public class ClienteCreatedResponse {

    private final Long id;
    private final String nome;

    public ClienteCreatedResponse(Long id, String nome) {
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
