package br.com.zupacademy.alison.casadocodigo.autor;

public class AutorSiteResponse {

    private final String nome;
    private final String descricao;

    public AutorSiteResponse(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

    public AutorSiteResponse(Autor autor) {
        this.nome = autor.getNome();
        this.descricao = autor.getDescricao();
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }
}
