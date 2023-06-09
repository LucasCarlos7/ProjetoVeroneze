package estoque;

import entidade.Fornecedor;
import produto.ProdutoCongelado;
import produto.ProdutoAcabado;
import java.sql.Date;

public class MovimentacaoEstoque {

    private int id;
    private ProdutoCongelado produtoCongelado;
    private ProdutoAcabado produtoAcabado;
    private Fornecedor fornecedor;
    private int operacao;
    private String operacaoNome;
    private double quantidade;
    private Double estoqueInicial;
    private Double estoqueSaida;
    private Double estoqueFinal;
    private Date data;

    // Construtor
    public MovimentacaoEstoque() {
    }
    
    public MovimentacaoEstoque(int id, double quantidade, int operacao, String operacaoNome, Fornecedor fornecedor, ProdutoCongelado produtoCongelado, Date data) {
        this.id = id;
        this.quantidade = quantidade;
        this.operacao = operacao;
        this.operacaoNome = operacaoNome;
        this.fornecedor = fornecedor;
        this.produtoCongelado = produtoCongelado;
        this.data = data;
    }

    public MovimentacaoEstoque(int id, double quantidade, double estoqueInicial, double estoqueSaida, double estoqueFinal, ProdutoAcabado produtoAcabado, ProdutoCongelado produtoCongelado, Date data) {
        this.id = id;
        this.quantidade = quantidade;
        this.estoqueInicial = estoqueInicial;
        this.estoqueSaida = estoqueSaida;
        this.estoqueFinal = estoqueFinal;
        this.produtoAcabado = produtoAcabado;
        this.produtoCongelado = produtoCongelado;
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ProdutoCongelado getProdutoCongelado() {
        return produtoCongelado;
    }

    public void setProdutoCongelado(ProdutoCongelado produtoCongelado) {
        this.produtoCongelado = produtoCongelado;
    }

    public ProdutoAcabado getProdutoAcabado() {
        return produtoAcabado;
    }

    public void setProdutoAcabado(ProdutoAcabado produtoAcabado) {
        this.produtoAcabado = produtoAcabado;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public int getOperacao() {
        return operacao;
    }

    public void setOperacao(int operacao) {
        this.operacao = operacao;
    }

    public String getOperacaoNome() {
        return operacaoNome;
    }

    public void setOperacaoNome(String operacaoNome) {
        this.operacaoNome = operacaoNome;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }

    public double getEstoqueInicial() {
        return estoqueInicial;
    }

    public void setEstoqueInicial(double estoqueInicial) {
        this.estoqueInicial = estoqueInicial;
    }

    public double getEstoqueSaida() {
        return estoqueSaida;
    }

    public void setEstoqueSaida(double estoqueSaida) {
        this.estoqueSaida = estoqueSaida;
    }

    public double getEstoqueFinal() {
        return estoqueFinal;
    }

    public void setEstoqueFinal(double estoqueFinal) {
        this.estoqueFinal = estoqueFinal;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

}
