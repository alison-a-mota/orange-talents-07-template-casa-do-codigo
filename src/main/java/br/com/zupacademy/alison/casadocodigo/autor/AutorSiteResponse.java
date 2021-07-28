package br.com.zupacademy.alison.casadocodigo.autor;

public class AutorSiteResponse {

    private final String nome;
    private final String descricao;

    public AutorSiteResponse(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

    public static AutorSiteResponse conversorResponse(Autor autor) {
        return new AutorSiteResponse(autor.getNome(), autor.getDescricao());
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    @Override
    public String toString() {
        return "AutorResponse{" +
                "nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}
