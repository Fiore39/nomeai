package br.com.propeest.armariosifsp.service;

import br.com.propeest.armariosifsp.exceptions.CriptoExistException;
import br.com.propeest.armariosifsp.exceptions.EmailExistsException;
import br.com.propeest.armariosifsp.exceptions.EntidadeNaoEncontradaException;
import br.com.propeest.armariosifsp.models.Aluno;
import br.com.propeest.armariosifsp.repositories.AlunoRepository;
import br.com.propeest.armariosifsp.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class ServiceAluno {

    @Autowired
    private AlunoRepository alunoRepository;

    public void salvarAluno(Aluno aluno) throws Exception{

        try {
            if (alunoRepository.findByEmail(aluno.getEmail()) != null) {
                throw new EmailExistsException("Email inserido já está sendo utilizado");
            }

            aluno.setSenha(Util.md5(aluno.getSenha()));
        } catch (NoSuchAlgorithmException e) {

            throw new CriptoExistException("Erro na criptografia da senha");

        }

        alunoRepository.save(aluno);
    }

    public Aluno loginAluno(String email, String senha) throws ServiceExc {

        Aluno alunoLogin = alunoRepository.buscarLogin(email, senha);
        return alunoLogin;

    }
    
    public Aluno buscarEmail(String email) {
    	Aluno aluno = alunoRepository.findByEmail(email.toLowerCase());
    	
    	if (aluno == null) {
    		throw new EntidadeNaoEncontradaException("Aluno não encontrado");
    	}
    	
    	return aluno;
    }
    
    public Boolean checkEmail(String email) {
    	Pattern pattern = Pattern.compile("ifsp.edu.br");
    	Matcher matcher = pattern.matcher(email.toLowerCase());
    	
    	if (matcher.find()) {
    		return true;
    	} else
    		return false;
    }
}
