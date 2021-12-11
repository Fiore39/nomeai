package br.com.propeest.armariosifsp.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Armario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	private String nome;
	
	@OneToMany(mappedBy = "armario")
    private List<Contrato> contratos = new ArrayList<>();
    
    @ManyToOne
    @JoinColumn(name = "bloco_id", nullable = false)
    private Bloco bloco;
    
    @Enumerated(EnumType.STRING)
    private StatusArmario status;

    public Armario() {

    }
    
    public Armario(Bloco bloco) {
    	this.bloco = bloco;
        this.status = StatusArmario.LIVRE;
    }

    public void reservar() {
        this.status = StatusArmario.RESERVADO;
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

	public List<Contrato> getContrato() {
		return contratos;
	}

	public void setContrato(List<Contrato> contratos) {
		this.contratos = contratos;
	}

	public Bloco getBloco() {
		return bloco;
	}

	public void setBloco(Bloco bloco) {
		this.bloco = bloco;
	}

	public StatusArmario getStatus() {
		return status;
	}

	public void setStatus(StatusArmario status) {
		this.status = status;
	}
    
}
