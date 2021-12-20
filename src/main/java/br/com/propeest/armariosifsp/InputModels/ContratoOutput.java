package br.com.propeest.armariosifsp.InputModels;

import java.time.OffsetDateTime;

import br.com.propeest.armariosifsp.models.AlunoContrato;

public class ContratoOutput {
	
	private Long id;
	private AlunoContratoOutput aluno;
	private AlunoContrato alunoContrato;
	private AlunoContratoOutput admin;
	private ArmarioInput armario;
	private OffsetDateTime dataAluguel;
    private OffsetDateTime dataVencimento;
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public AlunoContratoOutput getAluno() {
		return aluno;
	}
	public void setAluno(AlunoContratoOutput aluno) {
		this.aluno = aluno;
	}
	public AlunoContrato getAlunoContrato() {
		return alunoContrato;
	}
	public void setAlunoContrato(AlunoContrato alunoContrato) {
		this.alunoContrato = alunoContrato;
	}
	public AlunoContratoOutput getAdmin() {
		return admin;
	}
	public void setAdmin(AlunoContratoOutput admin) {
		this.admin = admin;
	}
	public ArmarioInput getArmario() {
		return armario;
	}
	public void setArmario(ArmarioInput armario) {
		this.armario = armario;
	}
	public OffsetDateTime getDataAluguel() {
		return dataAluguel;
	}
	public void setDataAluguel(OffsetDateTime dataAluguel) {
		this.dataAluguel = dataAluguel;
	}
	public OffsetDateTime getDataVencimento() {
		return dataVencimento;
	}
	public void setDataVencimento(OffsetDateTime dataVencimento) {
		this.dataVencimento = dataVencimento;
	}
	
}
