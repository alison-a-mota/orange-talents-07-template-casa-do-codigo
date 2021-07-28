package br.com.zupacademy.alison.casadocodigo.livro;

import java.util.List;
import java.util.stream.Collectors;

public class LivroListaTodosResponse {

    private Long id;
    private String titulo;

    public LivroListaTodosResponse(Livro livro) {
        this.id = livro.getId();
        this.titulo = livro.getTitulo();
    }

    public static List<LivroListaTodosResponse> toModel(List<Livro> livros) {
        return livros.stream().map(LivroListaTodosResponse::new).collect(Collectors.toList());
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    @Deprecated
    public LivroListaTodosResponse() {
    }
}
