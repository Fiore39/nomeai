package br.com.propeest.armariosifsp.InputModels;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class ConfirmaPagamentoInput {

	@NotNull
	private Long id;
	
	@Valid
	@NotNull
	private AlunoAluguelInput admin;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public AlunoAluguelInput getAdmin() {
		return admin;
	}

	public void setAdmin(AlunoAluguelInput admin) {
		this.admin = admin;
	}
	
}
