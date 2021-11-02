package br.com.propeest.armariosifsp.InputModels;

import javax.validation.constraints.NotNull;

public class LocalIdInput {

	@NotNull
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
}
