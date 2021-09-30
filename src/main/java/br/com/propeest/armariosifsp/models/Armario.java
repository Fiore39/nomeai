package br.com.propeest.armariosifsp.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Armario {

    private String id;
    private Aluno proprietario;
    private Contrato contrato;
    private String bloco;
    private String status;
    private String entidadeEstudantil;

    public Armario() {

    }

    public Armario(String id, Bloco bloco, String entidadeEstudantil) {
        this.id = id;
        this.bloco = bloco.getNome();
        this.entidadeEstudantil = entidadeEstudantil;
        this.status = "LIVRE";
    }

    public void reservar() {
        this.status = "RESERVADO";
    }

    public void alugar(Contrato contrato) {
        this.contrato = contrato;
        this.proprietario = contrato.getAluno();
        this.status = "ALUGADO";
    }

    public void liberar() {
        if (this.status.equals("ALUGADO")) {
            this.contrato = null;
            this.proprietario = null;
        }
        this.status = "LIVRE";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Aluno getProprietario() {
        return proprietario;
    }

    public void setProprietario(Aluno proprietario) {
        this.proprietario = proprietario;
    }

    public Contrato getContrato() {
        return contrato;
    }

    public void setContrato(Contrato contrato) {
        this.contrato = contrato;
    }

    public String getBloco() {
        return bloco;
    }

    public void setBloco(String bloco) {
        this.bloco = bloco;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getEntidadeEstudantil() {
        return entidadeEstudantil;
    }

    public void setEntidadeEstudantil(String entidadeEstudantil) {
        this.entidadeEstudantil = entidadeEstudantil;
    }
}
