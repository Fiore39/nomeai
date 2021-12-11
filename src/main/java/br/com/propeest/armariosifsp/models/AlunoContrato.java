package br.com.propeest.armariosifsp.models;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;

@Embeddable
public class AlunoContrato {
	
	@NotBlank
	@Column(name="aluno_rg")
	private String rgAluno;
	
	@NotBlank
	@Column(name="aluno_cpf")
    private String cpfAluno;
	
	@NotBlank
	@Column(name="aluno_registro")
    private String registroAluno;
	
	@NotBlank
	@Column(name="aluno_ano")
    private String anoAluno;
	
	@NotBlank
	@Column(name="aluno_turma")
    private String turmaAluno;
	
	@NotBlank
	@Column(name="aluno_telefone")
    private String telefoneAluno;

	public String getRgAluno() {
		return rgAluno;
	}

	public void setRgAluno(String rgAluno) {
		this.rgAluno = rgAluno;
	}

	public String getCpfAluno() {
		return cpfAluno;
	}

	public void setCpfAluno(String cpfAluno) {
		this.cpfAluno = cpfAluno;
	}

	public String getRegistroAluno() {
		return registroAluno;
	}

	public void setRegistroAluno(String registroAluno) {
		this.registroAluno = registroAluno;
	}

	public String getAnoAluno() {
		return anoAluno;
	}

	public void setAnoAluno(String anoAluno) {
		this.anoAluno = anoAluno;
	}

	public String getTurmaAluno() {
		return turmaAluno;
	}

	public void setTurmaAluno(String turmaAluno) {
		this.turmaAluno = turmaAluno;
	}

	public String getTelefoneAluno() {
		return telefoneAluno;
	}

	public void setTelefoneAluno(String telefoneAluno) {
		this.telefoneAluno = telefoneAluno;
	}
	
}
