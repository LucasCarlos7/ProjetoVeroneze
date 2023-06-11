package venda;

import entidade.Cliente;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import produto.ProdutoAcabado;

public class VendaDao {

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

    public int salvar(Venda venda) {
        int status;

        try {
            st = conn.prepareStatement("INSERT INTO venda (id, id_cliente, status_venda, valor_total, data) VALUES(?,?,?,?,?)");
            st.setInt(1, venda.getId());
            st.setInt(2, venda.getCliente().getId());
            st.setString(3, venda.getStatusVenda());
            st.setDouble(4, venda.getValorTotalFinal());
            st.setDate(5, (venda.getData()));
            status = st.executeUpdate();
            return status;
        } catch (SQLException e) {
            System.out.println("Erro ao conectar: " + e.getMessage());
            return e.getErrorCode();
        }
    }

    public Venda consultar(int id) {
        try {
            Venda venda = new Venda();
            Cliente cliente = new Cliente();
            st = conn.prepareStatement("SELECT v.id, c.nome FROM venda v, item_venda iv, cliente c, produtos_acabados pa WHERE v.id = iv.id_venda AND iv.id_produto_acabado = pa.id AND v.id = ?");
            st.setInt(1, id);
            rs = st.executeQuery();

            if (rs.next()) {
                venda.setId(rs.getInt("v.id"));
                cliente.setNomeCliente(rs.getString("c.nome"));
                venda.setCliente(cliente);

               return venda;
            } else {
                cliente.setId(0);
                cliente.setNomeCliente("");
                venda.setId(0);
                venda.setStatusVenda("");
                venda.setData(null);
                venda.setValorTotalFinal(0.0);
                return venda;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao conectar: " + e.getMessage());
            return null;
        }
    }
    
    public Venda consultarValorFinal(int id) {
        try {
            Venda venda = new Venda();
            
            st = conn.prepareStatement("SELECT SUM(iv.valor), iv.id_venda,pa.id FROM item_venda iv, venda v, produtos_acabados pa WHERE iv.id_venda = v.id AND iv.id_produto_acabado = pa.id AND iv.id_venda = ?");
            st.setInt(1, id);
            rs = st.executeQuery();

            if (rs.next()) {
                venda.setValorTotalFinal(rs.getDouble("SUM(iv.valor)"));
                return venda;
            } else {
                return venda;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao conectar: " + e.getMessage());
            return null;
        }
    }

    public boolean excluir(int id) {
        try {
            st = conn.prepareStatement("DELETE FROM venda WHERE id = ?");
            st.setInt(1, id);
            st.executeUpdate();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
    
    public int atualizar(Venda venda){
        int status;
        try{
            st = conn.prepareStatement("UPDATE venda SET valor_total = ? WHERE id = ?");
            st.setDouble(1, venda.getValorTotalFinal());
            st.setInt(2, venda.getId());
            status = st.executeUpdate();
            return status;
        }catch(SQLException e){
            System.out.println(e.getErrorCode());
            return e.getErrorCode();
        }
    }
    
    public int atualizarStatusVenda(Venda venda){
        int status;
        try{
            st = conn.prepareStatement("UPDATE venda SET status_venda = ? WHERE id = ?");
            st.setString(1, venda.getStatusVenda());
            st.setInt(2, venda.getId());
            status = st.executeUpdate();
            return status;
        }catch(SQLException e){
            System.out.println(e.getErrorCode());
            return e.getErrorCode();
        }
    }

    public int ProximoId() {
        int id = 0;
        try {

            st = conn.prepareStatement("SELECT id FROM venda");

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
