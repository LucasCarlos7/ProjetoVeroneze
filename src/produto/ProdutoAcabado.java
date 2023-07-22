package produto;

import java.sql.Date;

public class ProdutoAcabado extends Produto {

    private ProdutoCongelado produtoCongelado;

    // Construtor
    public ProdutoAcabado() {
    }

    public ProdutoAcabado(int id, String nome, String descricao, double preco, Date data, ProdutoCongelado produtoCongelado) {
        super(id, nome, descricao, preco, data);
        this.produtoCongelado = produtoCongelado;
    }

    // Getters e Setters
    public ProdutoCongelado getProdutoCongelado() {
        return produtoCongelado;
    }

    public void setProdutoCongelado(ProdutoCongelado produtoCongelado) {
        this.produtoCongelado = produtoCongelado;
    }

    // Médotos especiais
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ID: ");
        sb.append(super.getId());
        sb.append("Nome: ");
        sb.append(super.getNome());
        sb.append("Descrição: ");
        sb.append(super.getDescricao());
        sb.append("Preço: ");
        sb.append(super.getPreco());
        sb.append("Quantidade em Estoque: ");
        sb.append(super.getQuantidadeEmEstoque());

        return sb.toString();
    }
}
