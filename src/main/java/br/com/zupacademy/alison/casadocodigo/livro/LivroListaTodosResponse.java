package br.com.zupacademy.alison.casadocodigo.livro;

public class LivroListaTodosResponse {

    private final Long id;
    private final String titulo;

    public LivroListaTodosResponse(Livro livro) {
        this.id = livro.getId();
        this.titulo = livro.getTitulo();
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }
}
