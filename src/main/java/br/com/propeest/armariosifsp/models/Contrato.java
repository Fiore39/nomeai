package br.com.propeest.armariosifsp.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import java.time.OffsetDateTime;

@Entity
public class Contrato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    private Armario armario;
    
    @ManyToOne
    @JoinColumn(name = "aluno_id", nullable = true)
    private Aluno aluno;
    
    @OneToOne(targetEntity=Aluno.class, cascade=CascadeType.ALL)
    private Aluno admin;
    
	private OffsetDateTime dataAluguel;
    private OffsetDateTime dataVencimento;
    private String rgAluno;
    private String cpfAluno;
    private String registroAluno;
    private String anoAluno;
    private String turmaAluno;
    private String telefoneAluno;

    public Contrato() {
		super();
	}

	public Contrato(Long id, Armario armario, Aluno aluno, Aluno admin, OffsetDateTime dataAluguel, OffsetDateTime dataVencimento, String rgAluno, String cpfAluno, String registroAluno, String anoAluno, String turmaAluno, String telefoneAluno) {
        this.id = id;
        this.armario = armario;
        this.aluno = aluno;
        this.admin = admin;
        this.dataAluguel = dataAluguel;
        this.dataVencimento = dataVencimento;
        this.rgAluno = rgAluno;
        this.cpfAluno = cpfAluno;
        this.registroAluno = registroAluno;
        this.anoAluno = anoAluno;
        this.turmaAluno = turmaAluno;
        this.telefoneAluno = telefoneAluno;
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
