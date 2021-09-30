package br.com.propeest.armariosifsp.dto;

import br.com.propeest.armariosifsp.models.Aluno;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

//É uma classe DTO (Data Transfer Object)
public class RequisicaoNovoAluno {
    @NotBlank
    @NotNull
    private String nome;
    @NotBlank
    @NotNull
    private String email;
    @NotBlank
    @NotNull
    private String senha;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Aluno toAluno() {
        Aluno aluno = new Aluno();
        aluno.setNome(this.nome);
        aluno.setEmail(this.email);
        aluno.setSenha(this.senha);

        return aluno;
    }

    @Override
    public String toString() {
        return "RequisicaoNovoAluno{" +
                "nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
