package br.com.propeest.armariosifsp.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Local {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
    private String nome;
    
    @OneToMany(mappedBy = "local", cascade=CascadeType.ALL)
    private List<Bloco> blocos = new ArrayList<>();

    public Local(String nome) {
        this.nome = nome;
    }
    public void adicionarBloco(Bloco bloco) {
        this.blocos.add(bloco);
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
	
	public List<Bloco> getBlocos() {
		return blocos;
	}
	public void setBlocos(List<Bloco> blocos) {
		this.blocos = blocos;
	}
    
}
