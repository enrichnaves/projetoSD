package io.github.caio.grpc;

import java.math.BigInteger;
import java.util.ArrayList;

public class Usuario {
    private BigInteger CID;
    private String nome;
    private ArrayList<Tarefa> tarefas = new ArrayList<>();

    public Usuario(BigInteger CID, String nome) {
        this.CID = CID;
        this.nome = nome;
        this.tarefas = tarefas;
    }

    public BigInteger getCID() {
        return CID;
    }

    public void setCID(BigInteger CID) {
        this.CID = CID;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Tarefa> getTarefas() {
        return tarefas;
    }

    public void addTarefa(Tarefa t) {
        this.tarefas.add(t);
    }

    public void removeTarefa(Tarefa t){this.tarefas.remove(t);}

    @Override
    public String toString() {
        return "Usuario{" +
                "CID=" + CID +
                ", nome='" + nome + '\'' +
                ", tarefas=" + tarefas +
                '}';
    }
}
