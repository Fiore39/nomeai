package br.com.propeest.armariosifsp.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Contrato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Armario armario;
    private Aluno aluno;
    private Aluno admin;
    private Date inicioDoContrato;
    private Date fimDoContrato;
    private String rgAluno;
    private String cpfAluno;
    private String registroAluno;
    private String anoAluno;
    private String turmaAluno;
    private String telefoneAluno;

    public Contrato(Long id, Armario armario, Aluno aluno, Aluno admin, Date inicioDoContrato, Date fimDoContrato, String rgAluno, String cpfAluno, String registroAluno, String anoAluno, String turmaAluno, String telefoneAluno) {
        this.id = id;
        this.armario = armario;
        this.aluno = aluno;
        this.admin = admin;
        this.inicioDoContrato = inicioDoContrato;
        this.fimDoContrato = fimDoContrato;
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

    public Date getInicioDoContrato() {
        return inicioDoContrato;
    }

    public void setInicioDoContrato(Date inicioDoContrato) {
        this.inicioDoContrato = inicioDoContrato;
    }

    public Date getFimDoContrato() {
        return fimDoContrato;
    }

    public void setFimDoContrato(Date fimDoContrato) {
        this.fimDoContrato = fimDoContrato;
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
