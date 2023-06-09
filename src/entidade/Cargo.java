package entidade;

import java.util.ArrayList;
import java.util.List;

public class Cargo {
    private static int proximoId = 1;
    private int id;
    private String nome;
    private String descrição;
    
    public static List<Cargo> cargoList = new ArrayList<>();

    public Cargo() {
    }

    public Cargo(int id, String nome, String descrição) {
        this.id = proximoId++;
        this.nome = nome;
        this.descrição = descrição;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescrição() {
        return descrição;
    }

    public void setDescrição(String descrição) {
        this.descrição = descrição;
    }

    public List<Cargo> getCargoList() {
        return cargoList;
    }

    @Override
    public String toString() {
        return "Cargo{" + "id=" + id + ", nome=" + nome + ", descrição=" + descrição + ", cargoList=" + cargoList + '}';
    }
    
    
    public int proximoId (){
        int ultimoId = proximoId;
        return ultimoId;
    }
}
