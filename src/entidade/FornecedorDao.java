package entidade;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FornecedorDao {

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

    public int salvar(Fornecedor fornecedor) {
        int status;
        try {
            st = conn.prepareStatement("INSERT INTO fornecedor VALUES(?,?,?,?,?,?,?,?,?,?)");
            st.setInt(1, fornecedor.getId());
            st.setString(2, fornecedor.getNomeEmpresa());
            st.setString(3, fornecedor.getCnpj());
            st.setString(4, fornecedor.getEndereco());
            st.setString(5, fornecedor.getNumero());
            st.setString(6, fornecedor.getBairro());
            st.setString(7, (fornecedor.getCidade()));
            st.setString(8, (fornecedor.getUf()));
            st.setString(9, (fornecedor.getTelefone()));
            st.setString(10, (fornecedor.getEmail()));
            status = st.executeUpdate();
            return status;
        } catch (SQLException e) {
            System.out.println("Erro ao conectar: " + e.getMessage());
            return e.getErrorCode();
        }
    }

    public Fornecedor consultar(int id) {
        try {
            Fornecedor fornecedor = new Fornecedor();
            st = conn.prepareStatement("SELECT * FROM fornecedor WHERE id = ?");
            st.setInt(1, id);
            rs = st.executeQuery();

            if (rs.next()) {
                fornecedor.setId(rs.getInt("id"));
                fornecedor.setNomeEmpresa(rs.getString("nome"));
                fornecedor.setCnpj(rs.getString("cnpj"));
                fornecedor.setEndereco(rs.getString("endereco"));
                fornecedor.setNumero(rs.getString("numero"));
                fornecedor.setBairro(rs.getString("bairro"));
                fornecedor.setCidade(rs.getString("cidade"));
                fornecedor.setUf(rs.getString("uf"));
                fornecedor.setTelefone(rs.getString("telefone"));
                fornecedor.setEmail(rs.getString("email"));
                return fornecedor;
            } else {
                fornecedor.setId(0);
                fornecedor.setNomeEmpresa("");
                fornecedor.setCnpj("");
                fornecedor.setEndereco("");
                fornecedor.setNumero("");
                fornecedor.setCidade("");
                fornecedor.setCidade("");
                fornecedor.setUf("");
                fornecedor.setTelefone("");
                fornecedor.setEmail("");
                return fornecedor;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao conectar: " + e.getMessage());
            return null;
        }
    }

    public Fornecedor consultarNome(String nome) {
        try {
            Fornecedor fornecedor = new Fornecedor();
            st = conn.prepareStatement("SELECT * FROM fornecedor WHERE nome = ?");
            st.setString(1, nome);
            rs = st.executeQuery();

            if (rs.next()) {
                fornecedor.setId(rs.getInt("id"));
                fornecedor.setNomeEmpresa(rs.getString("nome"));
                fornecedor.setCnpj(rs.getString("cnpj"));
                fornecedor.setEndereco(rs.getString("endereco"));
                fornecedor.setNumero(rs.getString("numero"));
                fornecedor.setBairro(rs.getString("bairro"));
                fornecedor.setCidade(rs.getString("cidade"));
                fornecedor.setUf(rs.getString("uf"));
                fornecedor.setTelefone(rs.getString("telefone"));
                fornecedor.setEmail(rs.getString("email"));
                return fornecedor;
            } else {
                fornecedor.setId(0);
                fornecedor.setNomeEmpresa("");
                fornecedor.setCnpj("");
                fornecedor.setEndereco("");
                fornecedor.setNumero("");
                fornecedor.setCidade("");
                fornecedor.setCidade("");
                fornecedor.setUf("");
                fornecedor.setTelefone("");
                fornecedor.setEmail("");
                return fornecedor;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao conectar: " + e.getMessage());
            return null;
        }
    }
    
    public Fornecedor consultarCnpj(String cnpj) {
        try {
            Fornecedor fornecedor = new Fornecedor();
            st = conn.prepareStatement("SELECT * FROM fornecedor WHERE cnpj = ?");
            st.setString(1, cnpj);
            rs = st.executeQuery();

            if (rs.next()) {
                fornecedor.setId(rs.getInt("id"));
                fornecedor.setNomeEmpresa(rs.getString("nome"));
                fornecedor.setCnpj(rs.getString("cnpj"));
                fornecedor.setEndereco(rs.getString("endereco"));
                fornecedor.setNumero(rs.getString("numero"));
                fornecedor.setBairro(rs.getString("bairro"));
                fornecedor.setCidade(rs.getString("cidade"));
                fornecedor.setUf(rs.getString("uf"));
                fornecedor.setTelefone(rs.getString("telefone"));
                fornecedor.setEmail(rs.getString("email"));
                return fornecedor;
            } else {
                fornecedor.setId(0);
                fornecedor.setNomeEmpresa("");
                fornecedor.setCnpj("");
                fornecedor.setEndereco("");
                fornecedor.setNumero("");
                fornecedor.setCidade("");
                fornecedor.setCidade("");
                fornecedor.setUf("");
                fornecedor.setTelefone("");
                fornecedor.setEmail("");
                return fornecedor;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao conectar: " + e.getMessage());
            return null;
        }
    }

    public boolean excluir(int id) {
        try {
            st = conn.prepareStatement("DELETE FROM fornecedor WHERE id = ?");
            st.setInt(1, id);
            st.executeUpdate();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    public List<Fornecedor> getFornecedor() {
        String sql = "SELECT * FROM fornecedor";

        try {
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();

            List<Fornecedor> listFornecedor = new ArrayList<>();

            while (rs.next()) {

                Fornecedor fornecedor = new Fornecedor();

                fornecedor.setId(rs.getInt("id"));
                fornecedor.setNomeEmpresa(rs.getString("nome"));
                fornecedor.setCnpj(rs.getString("cnpj"));
                fornecedor.setEndereco(rs.getString("endereco"));
                fornecedor.setNumero(rs.getString("numero"));
                fornecedor.setBairro(rs.getString("bairro"));
                fornecedor.setCidade(rs.getString("cidade"));
                fornecedor.setUf(rs.getString("uf"));
                fornecedor.setTelefone(rs.getString("telefone"));
                fornecedor.setEmail(rs.getString("email"));

                listFornecedor.add(fornecedor);
            }
            return listFornecedor;
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

            st = conn.prepareStatement("SELECT id FROM fornecedor");
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
