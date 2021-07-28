package br.com.zupacademy.alison.casadocodigo.livro;

import java.math.BigDecimal;

public class LivroDetalhadoSiteResponse {

    private final String titulo;
    private final String resumo;
    private final String sumario;
    private final BigDecimal preco;
    private final Integer quantidadePaginas;
    private final String isbnIdentificador;

    public LivroDetalhadoSiteResponse(String titulo, String resumo, String sumario, BigDecimal preco, Integer quantidadePaginas, String isbnIdentificador) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.quantidadePaginas = quantidadePaginas;
        this.isbnIdentificador = isbnIdentificador;
    }

    public static LivroDetalhadoSiteResponse conversorResponse(Livro livro) {
        return new LivroDetalhadoSiteResponse(livro.getTitulo(), livro.getResumo(), livro.getSumario(), livro.getPreco(),
                livro.getQuantidadePaginas(), livro.getIsbnIdentificador());
    }

    public String getTitulo() {
        return titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public String getSumario() {
        return sumario;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public Integer getQuantidadePaginas() {
        return quantidadePaginas;
    }

    public String getIsbnIdentificador() {
        return isbnIdentificador;
    }

    @Override
    public String toString() {
        return "LivroDetalhadoResponse{" +
                "titulo='" + titulo + '\'' +
                ", resumo='" + resumo + '\'' +
                ", sumario='" + sumario + '\'' +
                ", preco=" + preco +
                ", quantidadePaginas=" + quantidadePaginas +
                ", isbnIdentificador='" + isbnIdentificador + '\'' +
                '}';
    }
}
