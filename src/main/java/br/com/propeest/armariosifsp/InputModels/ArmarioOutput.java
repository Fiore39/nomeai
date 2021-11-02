package br.com.propeest.armariosifsp.InputModels;

import br.com.propeest.armariosifsp.models.StatusArmario;

public class ArmarioOutput {

	private Long id;
	private String nome;
	private StatusArmario status;
	
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
	public StatusArmario getStatus() {
		return status;
	}
	public void setStatus(StatusArmario status) {
		this.status = status;
	}
	
	
}
