package entidade;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Funcionario {

    private static int proximoId = 1;
    private int id;
    private String nomeFuncionario;
    private String cpf;
    private String endereco;
    private String numero;
    private String bairro;
    private String cidade;
    private String uf;
    private String telefone;
    private String nomeCargo;
    private int idCargo;

    private static final List<Funcionario> funcionarioList = new ArrayList<>();

    //Construtor
    public Funcionario() {
    }

    public Funcionario(String nomeFuncionario, String cpf, String endereco, String numero, String bairro, String cidade, String uf, String telefone, String nomeCargo, int idCargo) {
        this.id = proximoId++;
        this.nomeFuncionario = nomeFuncionario;
        this.cpf = cpf;
        this.endereco = endereco;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.uf = uf;
        this.telefone = telefone;
        this.nomeCargo = nomeCargo;
        this.idCargo =  idCargo;
    }

    //Getters e Setters
    public int getId() {
        return id;
    }

    public String getNomeFuncionario() {
        return nomeFuncionario;
    }

    public void setNomeFuncionario(String nomeFuncionario) {
        this.nomeFuncionario = nomeFuncionario;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getNomeCargo() {
        return nomeCargo;
    }

    public void setNomeCargo(String nomeCargo) {
        this.nomeCargo = nomeCargo;
    }

    public int getIdCargo() {
        return idCargo;
    }

    public void setIdCargo(int idCargo) {
        this.idCargo = idCargo;
    }

    public static List<Funcionario> getFuncionarioList() {
        return funcionarioList;
    }

    // Metodos Especiais
    public void inserir(Funcionario funcionario) {
        
        funcionarioList.add(funcionario);
        
    }

    @Override
    public String toString() {
        return "\nId: " + getId()
                + "\nNome: " + getNomeFuncionario()
                + "\nCPF: " + getCpf()
                + "\nEndereço: " + getEndereco()
                + "\nNúmero: " + getNumero()
                + "\nBairro: " + getBairro()
                + "\nCidade: " + getCidade()
                + "\nUF: " + getUf()
                + "\nTelefone: " + getTelefone()
                + "\nEmail: " + getNomeCargo();
    }

    public int proximoId() {

        int ultimoId = proximoId;

        return ultimoId;
    }
}
