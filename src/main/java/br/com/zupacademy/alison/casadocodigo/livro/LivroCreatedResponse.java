package br.com.zupacademy.alison.casadocodigo.livro;

public class LivroCreatedResponse {

    private final Long id;
    private final String titulo;

    public LivroCreatedResponse(Long id, String titulo) {
        this.id = id;
        this.titulo = titulo;
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }
}
