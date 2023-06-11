package venda;

import produto.ProdutoAcabado;

public class ItemVenda {

    private int id;
    private ProdutoAcabado produtoAcabado;
    private double quantidade;
    private double valorTotal;
    private Venda venda;

    public ItemVenda() {
    }

    public ItemVenda(Venda venda, ProdutoAcabado produtoAcabado, double quantidade, double valorTotal) {
        this.venda = venda;
        this.produtoAcabado = produtoAcabado;
        this.quantidade = quantidade;
        this.valorTotal = valorTotal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ProdutoAcabado getProdutoAcabado() {
        return produtoAcabado;
    }

    public void setProdutoAcabado(ProdutoAcabado produtoAcabado) {
        this.produtoAcabado = produtoAcabado;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    @Override
    public String toString() {
        return "ItemVenda{ produtoAcabado=" + produtoAcabado + ", quantidade=" + quantidade + ", valorTotal=" + valorTotal + ", venda=" + venda + '}';
    }

}
