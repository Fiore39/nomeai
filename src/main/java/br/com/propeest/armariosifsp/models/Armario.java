package br.com.propeest.armariosifsp.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Armario {

    private String id;
    private Long idProprietário;
    private String bloco;
    private String local;
    private String status;
    private String entidadeEstudantil;

    public Armario() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getIdProprietário() {
        return idProprietário;
    }

    public void setIdProprietário(Long idProprietário) {
        this.idProprietário = idProprietário;
    }

    public String getBloco() {
        return bloco;
    }

    public void setBloco(String bloco) {
        this.bloco = bloco;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
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
