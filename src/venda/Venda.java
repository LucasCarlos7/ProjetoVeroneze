package venda;

import entidade.Cliente;
import java.sql.Date;

public class Venda {

    private int id;
    private Cliente cliente;
    private Date data;
    private String statusVenda;
    private double valorTotalFinal;

    public Venda() {
    }

    public Venda(int id, Cliente cliente, Date data) {
        this.id = id;
        this.cliente = cliente;
        this.data = data;
        this.statusVenda = "ABERTA";
        this.valorTotalFinal = 0.0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }
    
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getStatusVenda() {
        return statusVenda;
    }

    public void setStatusVenda(String statusVenda) {
        this.statusVenda = statusVenda;
    }

    public double getValorTotalFinal() {
        return valorTotalFinal;
    }

    public void setValorTotalFinal(double valorTotalFinal) {
        this.valorTotalFinal = valorTotalFinal;
    }

    @Override
    public String toString() {
        return "Venda{" + "id=" + id + ", cliente=" + cliente + ", data=" + data + ", statusVenda=" + statusVenda + ", valorTotalFinal=" + valorTotalFinal + '}';
    }
    
    
}
