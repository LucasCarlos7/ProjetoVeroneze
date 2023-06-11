package venda;

import entidade.Cliente;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import produto.ProdutoAcabado;

public class ItemVendaDao {

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

    public int salvar(ItemVenda itemVenda) {
        int status;

        try {
            st = conn.prepareStatement("INSERT INTO item_venda (id_venda, id_produto_acabado, quantidade, valor) VALUES(?,?,?,?)");
            st.setInt(1, (itemVenda.getVenda().getId()));
            st.setInt(2, (itemVenda.getProdutoAcabado().getId()));
            st.setDouble(3, itemVenda.getQuantidade());
            st.setDouble(4, itemVenda.getValorTotal());
            status = st.executeUpdate();
            return status;
        } catch (SQLException e) {
            System.out.println("Erro ao conectar: " + e.getMessage());
            return e.getErrorCode();
        }
    }

    public ItemVenda consultarItemLista(String nome, double quantidade, int id) {
        try {
            ItemVenda itemVenda = new ItemVenda();
            ProdutoAcabado acabado = new ProdutoAcabado();

            st = conn.prepareStatement("SELECT  pa.nome, pa.preco, iv.id, iv.quantidade, iv.valor, iv.id_venda FROM item_venda iv, venda v, produtos_acabados pa WHERE iv.id_venda = v.id AND iv.id_produto_acabado = pa.id AND pa.nome = ? AND iv.quantidade = ? AND iv.id_venda = ?");
            st.setString(1, nome);
            st.setDouble(2, quantidade);
            st.setInt(3, id);
            rs = st.executeQuery();

            if (rs.next()) {
                itemVenda.setId(rs.getInt("iv.id"));
                itemVenda.setQuantidade(rs.getDouble("iv.quantidade"));
                acabado.setNome(rs.getString("pa.nome"));
                return itemVenda;
            } else {
                return itemVenda;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao conectar: " + e.getMessage());
            return null;
        }
    }

    public ItemVenda consultar(int id) {
        try {
            Venda venda = new Venda();
            Cliente cliente = new Cliente();
            ItemVenda itemVenda = new ItemVenda();
            ProdutoAcabado acabado = new ProdutoAcabado();
            st = conn.prepareStatement("SELECT v.data, v.id, v.status_venda, v.valor_total, v.data, c.id, c.nome, pa.id, pa.nome, pa.preco, iv.id, iv.quantidade, iv.valor, iv.id_venda FROM item_venda iv, venda v, produtos_acabados pa, cliente c WHERE iv.id_venda = v.id AND iv.id_produto_acabado = pa.id AND c.id = v.id_cliente AND iv.id_venda = ?");
            st.setInt(1, id);
            rs = st.executeQuery();

            if (rs.next()) {
                venda.setId(rs.getInt("v.id"));
                venda.setStatusVenda(rs.getString("v.status_venda"));
                venda.setValorTotalFinal(rs.getDouble("v.valor_total"));
                venda.setData(rs.getDate("v.data"));

                cliente.setId(rs.getInt("c.id"));
                cliente.setNomeCliente(rs.getString("c.nome"));
                venda.setCliente(cliente);

                itemVenda.setId(rs.getInt("iv.id"));
                itemVenda.setQuantidade(rs.getDouble("iv.quantidade"));
                itemVenda.setValorTotal(rs.getDouble("iv.valor"));
                itemVenda.setVenda(venda);
                

                acabado.setId(rs.getInt("pa.id"));
                acabado.setNome(rs.getString("pa.nome"));
                acabado.setPreco(rs.getDouble("pa.preco"));
                itemVenda.setProdutoAcabado(acabado);

                return itemVenda;
            } else {
                cliente.setId(0);
                cliente.setNomeCliente("");
                venda.setId(0);
                venda.setStatusVenda("");
                venda.setData(null);
                venda.setValorTotalFinal(0.0);
                return itemVenda;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao conectar: " + e.getMessage());
            return null;
        }
    }

    public boolean excluir(int id) {
        try {
            st = conn.prepareStatement("DELETE FROM item_venda WHERE id = ?");
            st.setInt(1, id);
            st.executeUpdate();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    public List<ItemVenda> getItemVenda(int id) {

        String sql = "SELECT iv.id_venda, iv.valor, iv.quantidade,pa.id, pa.nome, pa.preco FROM item_venda iv, venda v, produtos_acabados pa WHERE iv.id_venda = v.id AND iv.id_produto_acabado = pa.id AND iv.id_venda = ?";

        try {
            st = conn.prepareStatement(sql);
            st.setInt(1, id);
            rs = st.executeQuery();

            List<ItemVenda> listItemVenda = new ArrayList<>();

            while (rs.next()) {

                ItemVenda itemVenda = new ItemVenda();
                ProdutoAcabado acabado = new ProdutoAcabado();

                acabado.setId(rs.getInt("pa.id"));
                acabado.setNome(rs.getString("pa.nome"));
                acabado.setPreco(rs.getDouble("pa.preco"));
                itemVenda.setQuantidade(rs.getDouble("iv.quantidade"));
                itemVenda.setValorTotal(rs.getDouble("iv.valor"));
                itemVenda.setProdutoAcabado(acabado);

                listItemVenda.add(itemVenda);
            }
            return listItemVenda;
        } catch (Exception e) {
            return null;
        }
    }

    public int ProximoId() {
        int id = 0;
        try {

            st = conn.prepareStatement("SELECT id FROM item_venda");

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
