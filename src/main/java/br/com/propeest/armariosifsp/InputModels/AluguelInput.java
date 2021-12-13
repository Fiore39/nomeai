package br.com.propeest.armariosifsp.InputModels;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import br.com.propeest.armariosifsp.models.AlunoContrato;

public class AluguelInput {
	
	@Valid
	@NotNull
	private AlunoAluguelInput aluno;
	
	@Valid
	@NotNull
	private AlunoContrato alunoContrato;
	
	@Valid
	@NotNull
	private ArmarioNomeInput armario;
	
	
	public AlunoAluguelInput getAluno() {
		return aluno;
	}
	public void setAluno(AlunoAluguelInput aluno) {
		this.aluno = aluno;
	}
	public AlunoContrato getAlunoContrato() {
		return alunoContrato;
	}
	public void setAlunoContrato(AlunoContrato alunoContrato) {
		this.alunoContrato = alunoContrato;
	}
	public ArmarioNomeInput getArmario() {
		return armario;
	}
	public void setArmario(ArmarioNomeInput armario) {
		this.armario = armario;
	}

}
