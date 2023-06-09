package venda;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Venda {
    
    private static int proximoId = 1;
    private int id;
    private int idCliente;
    private String nomeCliente;
    private LocalDate data;
    private String statusVenda;
    private double valorTotalFinal;
    private static final List<Venda> vendaList = new ArrayList<>();
    private static List<ItemVenda> itemVenda;

    public Venda() {
    }

    public Venda(int id, int idCliente, String nomeCliente, LocalDate data) {
        this.id = proximoId++;
        this.idCliente = idCliente;
        this.nomeCliente = nomeCliente;
        this.data = data;
        itemVenda = new ArrayList<>();
        statusVenda = "ABERTA";
        valorTotalFinal = 0.0;
    }

    public int getId() {
        return id;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public static int getProximoId() {
        return proximoId;
    }

    public static void setProximoId(int proximoId) {
        Venda.proximoId = proximoId;
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

    public static List<Venda> getVendaList() {
        return vendaList;
    }

    public static List<ItemVenda> getItemVenda() {
        return itemVenda;
    }
    public void adicionarItem(ItemVenda item){
        itemVenda.add(item);
    }    
    
    
    public int proximoId() {

        int ultimoId = proximoId;

        return ultimoId;
    }

    @Override
    public String toString() {
        return "Venda{" + "id=" + id + ", idCliente=" + idCliente + ", nomeCliente=" + nomeCliente + ", data=" + data + ", statusVenda=" + statusVenda + ", valorTotalFinal=" + valorTotalFinal + '}';
    }
    
}
