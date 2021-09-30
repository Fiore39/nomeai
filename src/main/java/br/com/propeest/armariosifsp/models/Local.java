package br.com.propeest.armariosifsp.models;

import javax.persistence.Entity;
import java.util.ArrayList;

@Entity
public class Local {

    //teste
    private String nome;
    private ArrayList<Bloco> blocos = new ArrayList<>();

    public Local(String nome) {
        this.nome = nome;
    }

    public void adicionarBloco(Bloco bloco) {
        this.blocos.add(bloco);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
