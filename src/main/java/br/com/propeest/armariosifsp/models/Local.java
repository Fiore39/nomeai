package br.com.propeest.armariosifsp.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Local {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    private String nome;
    
    @OneToMany(mappedBy = "local", cascade=CascadeType.ALL)
    private List<Bloco> blocos = new ArrayList<>();

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
