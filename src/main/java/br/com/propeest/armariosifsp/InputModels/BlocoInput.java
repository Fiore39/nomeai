package br.com.propeest.armariosifsp.InputModels;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class BlocoInput {

	@Valid
	@NotNull
	@NotBlank
	private String nome;
	
	@Valid
	@NotNull
	@NotBlank
	private String entidadeEstudantil;
	
	@Valid
	@NotNull
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
