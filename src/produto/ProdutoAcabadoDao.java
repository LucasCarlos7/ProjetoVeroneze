package produto;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdutoAcabadoDao {

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

    public int salvar(ProdutoAcabado acabado) {
        int status;

        try {
            st = conn.prepareStatement("INSERT INTO produtos_acabados VALUES(?,?,?,?,?,?,?)");
            st.setInt(1, acabado.getId());
            st.setString(2, acabado.getNome());
            st.setString(3, acabado.getDescricao());
            st.setDouble(4, acabado.getPreco());
            st.setDouble(5, acabado.getQuantidadeEmEstoque());
            st.setInt(6, acabado.getProdutoCongelado().getId());
            st.setDate(7, (acabado.getData()));
            status = st.executeUpdate();
            return status;
        } catch (SQLException e) {
            System.out.println("Erro ao conectar: " + e.getMessage());
            return e.getErrorCode();
        }
    }

    public ProdutoAcabado consultar(int id) {
        try {
            ProdutoAcabado acabado = new ProdutoAcabado();
            ProdutoCongelado congelado = new ProdutoCongelado();
            st = conn.prepareStatement("SELECT pa.id, pa.nome, pa.descricao, pa.preco, pa.quant_em_estoque, pa.data, pa.id_produto_congelado, pc.nome, pc.id, pc.quant_em_estoque, pc.proporcao FROM produtos_acabados pa inner join produtos_congelados pc WHERE pa.id = ?");
            st.setInt(1, id);
            rs = st.executeQuery();

            if (rs.next()) {
                acabado.setId(rs.getInt("id"));
                acabado.setNome(rs.getString("nome"));
                acabado.setDescricao(rs.getString("descricao"));
                acabado.setPreco(rs.getDouble("preco"));
                acabado.setQuantidadeEmEstoque(rs.getDouble("quant_em_estoque"));
                acabado.setData(rs.getDate("data"));
                
                congelado.setId(rs.getInt("pc.id"));
                congelado.setNome(rs.getString("pc.nome"));
                congelado.setQuantidadeEmEstoque(rs.getDouble("pc.quant_em_estoque"));
                congelado.setProporcao(rs.getDouble("pc.proporcao"));
                acabado.setProdutoCongelado(congelado);
                return acabado;
            } else {
                congelado.setId(0);
                congelado.setNome("");
                acabado.setId(0);
                acabado.setNome("");
                acabado.setDescricao("");
                acabado.setPreco(0.0);
                acabado.setQuantidadeEmEstoque(0.0);
                acabado.setProdutoCongelado(congelado);
                acabado.setData(null);
                return acabado;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao conectar: " + e.getMessage());
            return null;
        }
    }

    public ProdutoAcabado consultarNome(String nome) {
        try {
            ProdutoAcabado acabado = new ProdutoAcabado();
            ProdutoCongelado congelado = new ProdutoCongelado();
            st = conn.prepareStatement("SELECT pa.id, pa.nome, pa.descricao, pa.preco, pa.quant_em_estoque, pa.data, pa.id_produto_congelado, pc.nome, pc.id FROM produtos_acabados pa inner join produtos_congelados pc WHERE pa.nome = ?");
            st.setString(1, nome);
            rs = st.executeQuery();

            if (rs.next()) {
                acabado.setId(rs.getInt("id"));
                acabado.setNome(rs.getString("nome"));
                acabado.setDescricao(rs.getString("descricao"));
                acabado.setPreco(rs.getDouble("preco"));
                acabado.setQuantidadeEmEstoque(rs.getDouble("quant_em_estoque"));
                acabado.setData(rs.getDate("data"));
                
                congelado.setId(rs.getInt("pc.id"));
                congelado.setNome(rs.getString("pc.nome"));
                acabado.setProdutoCongelado(congelado);
                return acabado;
            } else {
                congelado.setId(0);
                congelado.setNome("");
                acabado.setId(0);
                acabado.setNome("");
                acabado.setDescricao("");
                acabado.setPreco(0.0);
                acabado.setQuantidadeEmEstoque(0.0);
                acabado.setProdutoCongelado(congelado);
                acabado.setData(null);
                return acabado;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao conectar: " + e.getMessage());
            return null;
        }
    }

    public boolean excluir(int id) {
        try {
            st = conn.prepareStatement("DELETE FROM produtos_acabados WHERE id = ?");
            st.setInt(1, id);
            st.executeUpdate();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    public List<ProdutoAcabado> getProdutoAcabado() {
        String sql = "SELECT pa.id, pa.nome, pa.descricao, pa.preco, pa.quant_em_estoque, pa.data, pa.id_produto_congelado, pc.nome, pc.id FROM produtos_acabados pa inner join produtos_congelados pc";

        try {
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();

            List<ProdutoAcabado> listProdutoAcabado = new ArrayList<>();

            while (rs.next()) {

                ProdutoAcabado acabado = new ProdutoAcabado();
                ProdutoCongelado congelado = new ProdutoCongelado();

                acabado.setId(rs.getInt("id"));
                acabado.setNome(rs.getString("nome"));
                acabado.setDescricao(rs.getString("descricao"));
                acabado.setPreco(rs.getDouble("preco"));
                acabado.setQuantidadeEmEstoque(rs.getDouble("quant_em_estoque"));
                
                congelado.setId(rs.getInt("pc.id"));
                congelado.setNome(rs.getString("pc.nome"));
                acabado.setProdutoCongelado(congelado);
                acabado.setData(rs.getDate("data"));

                listProdutoAcabado.add(acabado);
            }
            return listProdutoAcabado;
        } catch (Exception e) {
            return null;
        }
    }

    public int ProximoId() {
        int id = 0;
        try {

            st = conn.prepareStatement("SELECT id FROM produtos_acabados");
            
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
