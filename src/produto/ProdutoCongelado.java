package produto;

import java.sql.Date;

public class ProdutoCongelado extends Produto {

    private double proporcao;

    // Construtor
    public ProdutoCongelado() {
    }

    public ProdutoCongelado(int id, String nome, String descricao, double preco, Date data, double proporcao) {
        super(id, nome, descricao, preco, data);
        this.proporcao = proporcao;
    }

    // getters e setteres
    public double getProporcao() {
        return proporcao;
    }

    public void setProporcao(double proporcao) {
        this.proporcao = proporcao;
    }

    // metodos especiais
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Produto Cadastrado com sucesso!!!");
        sb.append("\nID: ");
        sb.append(super.getId());
        sb.append("\nNome: ");
        sb.append(super.getNome());
        sb.append("\nDescrição: ");
        sb.append(super.getDescricao());
        sb.append("\nPreço: ");
        sb.append("R$ "+ super.getPreco());
        sb.append("\nQuantidade em Estoque: ");
        sb.append(super.getQuantidadeEmEstoque() + " KG");
        sb.append("\nProporção: ");
        sb.append(getProporcao() + "%");

        return sb.toString();
    }

}
