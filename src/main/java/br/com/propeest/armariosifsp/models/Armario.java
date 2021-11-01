package br.com.propeest.armariosifsp.models;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Armario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	private String nome;
	@OneToOne
    private Contrato contrato;
    
    @ManyToOne
    private Bloco bloco;
    private String nomeBloco;
    
    @Enumerated(EnumType.STRING)
    private StatusArmario status;
    private String entidadeEstudantil;

    public Armario() {

    }

    public Armario(String nome, Bloco bloco, String entidadeEstudantil) {
        this.nome = nome;
        this.nomeBloco = bloco.getNome();
        this.entidadeEstudantil = entidadeEstudantil;
        this.status = StatusArmario.LIVRE;
    }
    
    public Armario(Bloco bloco) {
    	this.bloco = bloco;
        this.status = StatusArmario.LIVRE;
    }

    public void reservar() {
        this.status = StatusArmario.RESERVADO;
    }

    public void alugar(Contrato contrato) {
        this.contrato = contrato;
        this.status = StatusArmario.ALUGADO;
    }

    public void liberar() {
        if (this.status.equals(StatusArmario.ALUGADO)) {
            this.contrato = null;
        }
        this.status = StatusArmario.LIVRE;
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

	public Contrato getContrato() {
		return contrato;
	}

	public void setContrato(Contrato contrato) {
		this.contrato = contrato;
	}

	public Bloco getBloco() {
		return bloco;
	}

	public void setBloco(Bloco bloco) {
		this.bloco = bloco;
	}

	public String getNomeBloco() {
		return nomeBloco;
	}

	public void setNomeBloco(String nomeBloco) {
		this.nomeBloco = nomeBloco;
	}

	public StatusArmario getStatus() {
		return status;
	}

	public void setStatus(StatusArmario status) {
		this.status = status;
	}

	public String getEntidadeEstudantil() {
		return entidadeEstudantil;
	}

	public void setEntidadeEstudantil(String entidadeEstudantil) {
		this.entidadeEstudantil = entidadeEstudantil;
	}

    
}
