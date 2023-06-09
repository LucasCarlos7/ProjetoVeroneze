package entidade;

import javax.swing.JOptionPane;

public class Fornecedor {
    private int id;
    private String nomeEmpresa;
    private String cnpj;
    private String endereco;
    private String numero;
    private String bairro;
    private String cidade;
    private String uf;
    private String telefone;
    private String email;

    //Construtor

    public Fornecedor() {
    }

    public Fornecedor(int id, String nomeEmpresa, String cnpj, String endereco, String numero, String bairro, String cidade, String uf, String telefone, String email) {
        this.id = id;
        this.nomeEmpresa = nomeEmpresa;
        this.cnpj = cnpj;
        this.endereco = endereco;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.uf = uf;
        this.telefone = telefone;
        this.email = email;
    }

    //Getters e Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getNomeEmpresa() {
        return nomeEmpresa;
    }

    public void setNomeEmpresa(String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    // Metodos Especiais

   
    @Override
    public String toString() {
        return "\nId: " + getId() +
                "\nNome: " + getNomeEmpresa() +
                "\nCNPJ: " + getCnpj() +
                "\nEndereço: " + getEndereco() +
                "\nNúmero: " + getNumero() +
                "\nBairro: " + getBairro() +
                "\nCidade: " + getCidade() +
                "\nUF: " + getUf() +
                "\nTelefone: " + getTelefone() +
                "\nEmail: " + getEmail();
    }
}
