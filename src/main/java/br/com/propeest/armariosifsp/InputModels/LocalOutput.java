package br.com.propeest.armariosifsp.InputModels;

import javax.validation.constraints.NotBlank;

public class LocalOutput {

	private Long id;
	
	@NotBlank
	private String nome;
	
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
	
}
