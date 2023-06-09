package estoque;

import entidade.Fornecedor;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import produto.ProdutoCongelado;

public class MovimentacaoEstoqueDao {

    Connection conn;
    PreparedStatement st;
    ResultSet rs;

    public boolean conectar() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Veroneze", "root", "lc171299");
            return true;
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Erro ao conectar: " + e.getMessage());
            return false;
        }
    }

    public void desconectar() {
        try {
            conn.close();
        } catch (SQLException e) {

        }
    }

    public int salvarCongelado(MovimentacaoEstoque estoque) {
        int status;
        try {
            st = conn.prepareStatement("INSERT INTO movimentacao_estoque (id, quantidade,  id_operacao, nome_operacao, id_fornecedor, id_produto_congelado, data ) VALUES(?,?,?,?,?,?,?)");
            st.setInt(1, estoque.getId());
            st.setDouble(2, estoque.getQuantidade());
            st.setInt(3, estoque.getOperacao());
            st.setString(4, estoque.getOperacaoNome());
            st.setInt(5, estoque.getFornecedor().getId());
            st.setInt(6, estoque.getProdutoCongelado().getId());
            st.setDate(7, estoque.getData());
            status = st.executeUpdate();
            return status;
        } catch (SQLException e) {
            System.out.println("Erro ao conectar: " + e.getMessage());
            return e.getErrorCode();
        }
    }

    public int salvarTransferencia(MovimentacaoEstoque estoque) {
        int status;
        try {
            st = conn.prepareStatement("INSERT INTO movimentacao_estoque (id, quantidade,  estoque_inicial, estoque_saida, estoque_final, id_produto_congelado, id_produto_acabado, data ) VALUES(?,?,?,?,?,?,?,?)");
            st.setInt(1, estoque.getId());
            st.setDouble(2, estoque.getQuantidade());
            st.setDouble(3, estoque.getEstoqueInicial());
            st.setDouble(4, estoque.getEstoqueSaida());
            st.setDouble(5, estoque.getEstoqueFinal());
            st.setInt(6, estoque.getProdutoCongelado().getId());
            st.setInt(7, estoque.getProdutoAcabado().getId());
            st.setDate(8, estoque.getData());
            status = st.executeUpdate();
            return status;
        } catch (SQLException e) {
            System.out.println("Erro ao conectar: " + e.getMessage());
            return e.getErrorCode();
        }
    }

    public MovimentacaoEstoque consultarCongelado(int id) {
        try {
            MovimentacaoEstoque estoque = new MovimentacaoEstoque();
            ProdutoCongelado congelado = new ProdutoCongelado();
            Fornecedor fornecedor = new Fornecedor();

            st = conn.prepareStatement("SELECT mv.id, mv.id_operacao, mv.nome_operacao, mv.data, mv.quantidade, f.id, f.nome as nome_fornecedor, pc.id, pc.nome as nome_congelado FROM movimentacao_estoque mv INNER JOIN produtos_congelados pc INNER JOIN fornecedor f WHERE mv.id = ?");
            st.setInt(1, id);
            rs = st.executeQuery();

            if (rs.next()) {
                estoque.setId(rs.getInt("id"));
                estoque.setOperacao(rs.getInt("id_operacao"));
                estoque.setOperacaoNome(rs.getString("nome_operacao"));
                estoque.setQuantidade(rs.getDouble("quantidade"));
                estoque.setData(rs.getDate("data"));

                fornecedor.setId(rs.getInt("f.id"));
                fornecedor.setNomeEmpresa(rs.getString("nome_fornecedor"));

                congelado.setId(rs.getInt("pc.id"));
                congelado.setNome(rs.getString("nome_congelado"));
                estoque.setProdutoCongelado(congelado);
                estoque.setFornecedor(fornecedor);
                return estoque;
            } else {
                congelado.setId(0);
                congelado.setNome("");
                fornecedor.setId(0);
                fornecedor.setNomeEmpresa("");

                estoque.setId(0);
                estoque.setOperacaoNome("");
                estoque.setOperacao(0);
                estoque.setQuantidade(0.0);
                estoque.setProdutoCongelado(congelado);
                estoque.setFornecedor(fornecedor);
                estoque.setData(null);
                return estoque;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao conectar: " + e.getMessage());
            return null;
        }
    }

    public MovimentacaoEstoque consultarTransferencia(int id) {
        try {
            MovimentacaoEstoque estoque = new MovimentacaoEstoque();
            ProdutoCongelado congelado = new ProdutoCongelado();
            Fornecedor fornecedor = new Fornecedor();

            st = conn.prepareStatement("SELECT mv.id, mv.id_operacao, mv.nome_operacao, mv.data, mv.quantidade, f.id_fornecedor, f.nome as nome_fornecedor, pc.id_produto_congelado, pc.nome as nome_congelado FROM movimentacao_estoque mv INNER JOIN produtos_congelados pc INNER JOIN fornecedor f WHERE pa.id = ?");
            st.setInt(1, id);
            rs = st.executeQuery();

            if (rs.next()) {
                estoque.setId(rs.getInt("mv.id"));
                estoque.setOperacao(rs.getInt("mv.id_operacao"));
                estoque.setOperacaoNome(rs.getString("mv.nome_operacao"));
                estoque.setQuantidade(rs.getDouble("mv.quantidade"));
                estoque.setData(rs.getDate("mv.data"));

                fornecedor.setId(rs.getInt("f.id_fornecedor"));
                fornecedor.setNomeEmpresa(rs.getString("nome_fornecedor"));

                congelado.setId(rs.getInt("pc.id_produto_congelado"));
                congelado.setNome(rs.getString("nome_congelado"));
                estoque.setProdutoCongelado(congelado);
                estoque.setFornecedor(fornecedor);
                return estoque;
            } else {
                congelado.setId(0);
                congelado.setNome("");
                fornecedor.setId(0);
                fornecedor.setNomeEmpresa("");

                estoque.setId(0);
                estoque.setOperacaoNome("");
                estoque.setOperacao(0);
                estoque.setQuantidade(0.0);
                estoque.setProdutoCongelado(congelado);
                estoque.setFornecedor(fornecedor);
                estoque.setData(null);
                return estoque;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao conectar: " + e.getMessage());
            return null;
        }
    }

    public boolean excluir(int id) {
        try {
            st = conn.prepareStatement("DELETE FROM movimentacao_estoque WHERE id = ?");
            st.setInt(1, id);
            st.executeUpdate();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    public int ProximoId() {
        int id = 0;
        try {

            st = conn.prepareStatement("SELECT id FROM movimentacao_estoque");

            rs = st.executeQuery();

            while (rs.next()) {
                id = rs.getInt("id");
            }
            return id;
        } catch (SQLException e) {
            return id;
        }
    }
}
