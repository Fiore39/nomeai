package br.com.propeest.armariosifsp.InputModels;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class BlocoInput {

	@Valid
	@NotNull
	private String nome;
	
	@Valid
	@NotNull
	private String entidadeEstudantil;
	
	private LocalIdInput local;
	
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
	public LocalIdInput getLocal() {
		return local;
	}
	public void setLocal(LocalIdInput local) {
		this.local = local;
	}
	
	
	
}
