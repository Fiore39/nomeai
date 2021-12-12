package br.com.propeest.armariosifsp.InputModels;

import br.com.propeest.armariosifsp.models.StatusArmario;

public class ArmarioInput {

	private String nome;
	private StatusArmario status;
	
	
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
