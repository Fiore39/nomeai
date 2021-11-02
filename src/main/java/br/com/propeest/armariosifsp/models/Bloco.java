package br.com.propeest.armariosifsp.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Bloco {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    private String nome;
    
    @NotBlank
    private String entidadeEstudantil;
    
    @OneToMany(mappedBy = "bloco", cascade=CascadeType.ALL)
    private List<Armario> armarios = new ArrayList<>();
    
    @ManyToOne
    @JoinColumn(name = "local_id", nullable = true)
    private Local local;

    public Bloco() {
		super();
	}

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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEntidadeEstudantil() {
		return entidadeEstudantil;
	}

	public void setEntidadeEstudantil(String entidadeEstudantil) {
		this.entidadeEstudantil = entidadeEstudantil;
	}

	public List<Armario> getArmarios() {
		return armarios;
	}

	public void setArmarios(List<Armario> armarios) {
		this.armarios = armarios;
	}

	public Local getLocal() {
		return local;
	}

	public void setLocal(Local local) {
		this.local = local;
	}
}
