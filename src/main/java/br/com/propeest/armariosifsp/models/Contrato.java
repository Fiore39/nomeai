package br.com.propeest.armariosifsp.models;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import java.time.OffsetDateTime;

@Entity
public class Contrato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "armario_id", nullable = false)
    private Armario armario;
    
    @ManyToOne
    @JoinColumn(name = "aluno_id", nullable = false)
    private Aluno aluno;
    
    @ManyToOne
    @JoinColumn(name = "admin_id", nullable = true)
    private Aluno admin;
    
    @Embedded
    private AlunoContrato alunoContrato;

    private OffsetDateTime dataAluguel;
    private OffsetDateTime dataVencimento;
    private Boolean ativo;
    
    public Contrato() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Armario getArmario() {
		return armario;
	}

	public void setArmario(Armario armario) {
		this.armario = armario;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Aluno getAdmin() {
		return admin;
	}

	public void setAdmin(Aluno admin) {
		this.admin = admin;
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

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public AlunoContrato getAlunoContrato() {
		return alunoContrato;
	}

	public void setAlunoContrato(AlunoContrato alunoContrato) {
		this.alunoContrato = alunoContrato;
	}
    
}
