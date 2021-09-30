package br.com.propeest.armariosifsp.models;

import javax.persistence.Entity;
import java.util.ArrayList;

@Entity
public class Bloco {

    private String nome;
    private String entidadeEstudantil;
    private ArrayList<Armario> armarios = new ArrayList<>();

    public Bloco(String nome, String entidadeEstudantil) {
        this.nome = nome;
        this.entidadeEstudantil = entidadeEstudantil;
        for (int i = 0; i < 16; i++) {
            Armario armario = new Armario(nome + i, this, entidadeEstudantil);
            adicionarArmario(armario);
        }
    }

    public void adicionarArmario(Armario armario) {
        this.armarios.add(armario);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
