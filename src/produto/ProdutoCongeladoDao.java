package produto;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdutoCongeladoDao {

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

    public int salvar(ProdutoCongelado congelado) {
        int status;
        try {
            st = conn.prepareStatement("INSERT INTO produtos_congelados VALUES(?,?,?,?,?,?,?)");
            st.setInt(1, congelado.getId());
            st.setString(2, congelado.getNome());
            st.setString(3, congelado.getDescricao());
            st.setDouble(4, congelado.getPreco());
            st.setDouble(5, congelado.getQuantidadeEmEstoque());
            st.setDouble(6, congelado.getProporcao());
            st.setDate(7, (congelado.getData()));
            status = st.executeUpdate();
            return status;
        } catch (SQLException e) {
            System.out.println("Erro ao conectar: " + e.getMessage());
            return e.getErrorCode();
        }
    }

    public ProdutoCongelado consultar(int id) {
        try {
            ProdutoCongelado congelado = new ProdutoCongelado();
            st = conn.prepareStatement("SELECT * FROM produtos_congelados WHERE id = ?");
            st.setInt(1, id);
            rs = st.executeQuery();

            if (rs.next()) {
                congelado.setId(rs.getInt("id"));
                congelado.setNome(rs.getString("nome"));
                congelado.setDescricao(rs.getString("descricao"));
                congelado.setPreco(rs.getDouble("preco"));
                congelado.setQuantidadeEmEstoque(rs.getDouble("quant_em_estoque"));
                congelado.setProporcao(rs.getDouble("proporcao"));
                congelado.setData(rs.getDate("data"));
                return congelado;
            } else {
                congelado.setId(0);
                congelado.setNome("");
                congelado.setDescricao("");
                congelado.setPreco(0.0);
                congelado.setQuantidadeEmEstoque(0.0);
                congelado.setProporcao(0.0);
                congelado.setData(null);
                return congelado;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao conectar: " + e.getMessage());
            return null;
        }
    }

    public ProdutoCongelado consultarNome(String nome) {
        try {
            ProdutoCongelado congelado = new ProdutoCongelado();
            st = conn.prepareStatement("SELECT * FROM produtos_congelados WHERE nome = ?");
            st.setString(1, nome);
            rs = st.executeQuery();

            if (rs.next()) {
                congelado.setId(rs.getInt("id"));
                congelado.setNome(rs.getString("nome"));
                congelado.setDescricao(rs.getString("descricao"));
                congelado.setPreco(rs.getDouble("preco"));
                congelado.setQuantidadeEmEstoque(rs.getDouble("quant_em_estoque"));
                congelado.setProporcao(rs.getDouble("proporcao"));
                congelado.setData(rs.getDate("data"));
                return congelado;
            } else {
                congelado.setId(0);
                congelado.setNome("");
                congelado.setDescricao("");
                congelado.setPreco(0.0);
                congelado.setQuantidadeEmEstoque(0.0);
                congelado.setProporcao(0.0);
                congelado.setData(null);
                return congelado;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao conectar: " + e.getMessage());
            return null;
        }
    }

    public boolean excluir(int id) {
        try {
            st = conn.prepareStatement("DELETE FROM produtos_congelados WHERE id = ?");
            st.setInt(1, id);
            st.executeUpdate();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    public List<ProdutoCongelado> getProdutoCongelado() {
        String sql = "SELECT * FROM produtos_congelados";

        try {
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();

            List<ProdutoCongelado> listProdutoCongelado = new ArrayList<>();

            while (rs.next()) {

                ProdutoCongelado congelado = new ProdutoCongelado();

                congelado.setId(rs.getInt("id"));
                congelado.setNome(rs.getString("nome"));
                congelado.setDescricao(rs.getString("descricao"));
                congelado.setPreco(rs.getDouble("preco"));
                congelado.setQuantidadeEmEstoque(rs.getDouble("quant_em_estoque"));
                congelado.setProporcao(rs.getDouble("proporcao"));
                congelado.setData(rs.getDate("data"));

                listProdutoCongelado.add(congelado);
            }
            return listProdutoCongelado;
        } catch (Exception e) {
            return null;
        }
    }

    public void desconectar() {
        try {
            conn.close();
        } catch (SQLException e) {

        }
    }

    public int ProximoId() {
        int id = 0;
        try {

            st = conn.prepareStatement("SELECT id FROM produtos_congelados");
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
