package produto;

import java.sql.Date;

public class ProdutoAcabado {
    private int id;
    private String nome;
    private String descricao;
    private double preco;
    private double quantidadeEmEstoque;
    private ProdutoCongelado produtoCongelado;
    private Date data;

    // Construtor
    
    public ProdutoAcabado() {
    }

    public ProdutoAcabado(int id, String nome, String descricao, double preco, ProdutoCongelado produtoCongelado, Date data) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.quantidadeEmEstoque = 0;
        this.produtoCongelado = produtoCongelado;
        this.data = data;
    }

    // Getters e Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public double getQuantidadeEmEstoque() {
        return quantidadeEmEstoque;
    }

    public void setQuantidadeEmEstoque(double quantidadeEmEstoque) {
        this.quantidadeEmEstoque = quantidadeEmEstoque;
    }

    public ProdutoCongelado getProdutoCongelado() {
        return produtoCongelado;
    }

    public void setProdutoCongelado(ProdutoCongelado produtoCongelado) {
        this.produtoCongelado = produtoCongelado;
    }    

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    // Médotos especiais


    @Override
    public String toString() {
        return  "PRODUTO ADICIONADO COM SUCESSO!\n" +
                "\nID: " + getId() +
                "\nNome: " + getNome() +
                "\nDescricão: " + getDescricao() +
                "\nPreço: " + getPreco() +
                "\nQuantidade em Estoque: " + getQuantidadeEmEstoque();
    }
}
