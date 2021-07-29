package br.com.zupacademy.alison.casadocodigo.autor;

public class AutorCreatedResponse {

    private final Long id;
    private final String nome;

    public AutorCreatedResponse(Long id, String nome) {
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
