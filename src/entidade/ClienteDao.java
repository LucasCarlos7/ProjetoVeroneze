package entidade;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDao {

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

    public int salvar(Cliente cliente) {
        int status;
        try {
            st = conn.prepareStatement("INSERT INTO cliente VALUES (?,?,?,?,?,?,?,?,?,?)");
            st.setInt(1, cliente.getId());
            st.setString(2, cliente.getNomeCliente());
            st.setString(3, cliente.getCnpj());
            st.setString(4, cliente.getEndereco());
            st.setString(5, cliente.getNumero());
            st.setString(6, cliente.getBairro());
            st.setString(7, cliente.getCidade());
            st.setString(8, cliente.getUf());
            st.setString(9, cliente.getTelefone());
            st.setString(10, cliente.getEmail());
            status = st.executeUpdate();
            return status;
        } catch (SQLException e) {
            System.out.println("Erro ao conectar: " + e.getMessage());
            return e.getErrorCode();
        }
    }

    public Cliente consultar(int id) {
        try {
            Cliente cliente = new Cliente();
            st = conn.prepareStatement("SELECT * FROM cliente WHERE id = ?");
            st.setInt(1, id);
            rs = st.executeQuery();

            if (rs.next()) {
                cliente.setId(rs.getInt("id"));
                cliente.setNomeCliente(rs.getString("nome"));
                cliente.setCnpj(rs.getString("cnpj"));
                cliente.setEndereco(rs.getString("endereco"));
                cliente.setNumero(rs.getString("numero"));
                cliente.setBairro(rs.getString("bairro"));
                cliente.setCidade(rs.getString("cidade"));
                cliente.setUf(rs.getString("uf"));
                cliente.setTelefone(rs.getString("telefone"));
                cliente.setEmail(rs.getString("email"));
                return cliente;
            } else {
                cliente.setId(0);
                cliente.setNomeCliente("");
                cliente.setCnpj("");
                cliente.setEndereco("");
                cliente.setNumero("");
                cliente.setBairro("");
                cliente.setCidade("");
                cliente.setUf("");
                cliente.setTelefone("");
                cliente.setEmail("");
                return cliente;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao conectar: " + e.getMessage());
            return null;
        }
    }

    public Cliente consultarNome(String nome) {
        try {
            Cliente cliente = new Cliente();
            st = conn.prepareStatement("SELECT * FROM cliente WHERE nome = ?");
            st.setString(1, nome);
            rs = st.executeQuery();

            if (rs.next()) {
                cliente.setId(rs.getInt("id"));
                cliente.setNomeCliente(rs.getString("nome"));
                cliente.setCnpj(rs.getString("cnpj"));
                cliente.setEndereco(rs.getString("endereco"));
                cliente.setNumero(rs.getString("numero"));
                cliente.setBairro(rs.getString("bairro"));
                cliente.setCidade(rs.getString("cidade"));
                cliente.setUf(rs.getString("uf"));
                cliente.setTelefone(rs.getString("telefone"));
                cliente.setEmail(rs.getString("email"));
                return cliente;
            } else {
                cliente.setId(0);
                cliente.setNomeCliente("");
                cliente.setCnpj("");
                cliente.setEndereco("");
                cliente.setNumero("");
                cliente.setBairro("");
                cliente.setCidade("");
                cliente.setUf("");
                cliente.setTelefone("");
                cliente.setEmail("");
                return cliente;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao conectar: " + e.getMessage());
            return null;
        }
    }

    public boolean excluir(int id) {
        try {
            st = conn.prepareStatement("DELETE FROM cliente WHERE id = ?");
            st.setInt(1, id);
            st.executeUpdate();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    public List<Cliente> getCliente() {
        String sql = "SELECT * FROM cliente";

        try {
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();

            List<Cliente> listCliente = new ArrayList<>();

            while (rs.next()) {

                Cliente cliente = new Cliente();

                cliente.setId(rs.getInt("id"));
                cliente.setNomeCliente(rs.getString("nome"));
                cliente.setCnpj(rs.getString("cnpj"));
                cliente.setEndereco(rs.getString("endereco"));
                cliente.setNumero(rs.getString("numero"));
                cliente.setBairro(rs.getString("bairro"));
                cliente.setCidade(rs.getString("cidade"));
                cliente.setUf(rs.getString("uf"));
                cliente.setTelefone(rs.getString("telefone"));
                cliente.setEmail(rs.getString("email"));

                listCliente.add(cliente);
            }
            return listCliente;
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

            st = conn.prepareStatement("SELECT id FROM cliente");
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
