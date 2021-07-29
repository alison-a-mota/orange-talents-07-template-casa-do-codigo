package br.com.zupacademy.alison.casadocodigo.categoria;

public class CategoriaCreatedResponse {

    private final Long id;
    private final String nome;

    public CategoriaCreatedResponse(Long id, String nome) {
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
