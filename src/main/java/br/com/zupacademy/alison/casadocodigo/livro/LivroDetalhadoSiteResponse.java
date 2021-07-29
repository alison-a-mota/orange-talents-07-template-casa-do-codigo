package br.com.zupacademy.alison.casadocodigo.livro;

import br.com.zupacademy.alison.casadocodigo.autor.Autor;
import br.com.zupacademy.alison.casadocodigo.autor.AutorSiteResponse;

import java.math.BigDecimal;

public class LivroDetalhadoSiteResponse {

    private final String titulo;
    private final String resumo;
    private final String sumario;
    private final BigDecimal preco;
    private final Integer quantidadePaginas;
    private final String isbnIdentificador;
    private final AutorSiteResponse autorSiteResponse;

    public LivroDetalhadoSiteResponse(Livro livro, Autor autor) {
        this.titulo = livro.getTitulo();
        this.resumo = livro.getResumo();
        this.sumario = livro.getSumario();
        this.preco = livro.getPreco();
        this.quantidadePaginas = livro.getQuantidadePaginas();
        this.isbnIdentificador = livro.getIsbnIdentificador();
        this.autorSiteResponse = new AutorSiteResponse(autor);
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

    public AutorSiteResponse getAutorSiteResponse() {
        return autorSiteResponse;
    }
}
