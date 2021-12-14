package br.com.propeest.armariosifsp.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import br.com.propeest.armariosifsp.InputModels.LocalOutput;
import br.com.propeest.armariosifsp.assembler.LocalAssembler;
import br.com.propeest.armariosifsp.exceptions.NegocioException;
import br.com.propeest.armariosifsp.models.Local;
import br.com.propeest.armariosifsp.repositories.LocalRepository;

@Service
public class ServiceLocal {
	
	private LocalRepository localRepository;
	private LocalAssembler localAssembler;

	public ServiceLocal(LocalRepository localRepository, LocalAssembler localAssembler) {
		super();
		this.localRepository = localRepository;
		this.localAssembler = localAssembler;
	}
	
	public List<LocalOutput> listar(){
		List<Local> locais = localRepository.findAll();
		List<LocalOutput> locaisOutput = new ArrayList<>();
		
		for(Local local : locais) {
			locaisOutput.add(localAssembler.toModel(local));
		}
		return locaisOutput;
	}

	@Transactional
	public LocalOutput adicionar(String nome) {
		Local local = new Local(nome);
		return localAssembler.toModel(localRepository.save(local));
	}
	
	@Transactional
	public LocalOutput atualizar(LocalOutput localOutput) {
		if(!localRepository.existsById(localOutput.getId())) {
			throw new NegocioException("Id de Local Inválido!");
		}
		
		return localAssembler.toModel(
				localRepository.save(localAssembler.toEntity(localOutput))
		);
	}
	
	@Transactional
	public void excluir(Long idlocal) {
		if(!localRepository.existsById(idlocal)) {
			throw new NegocioException("Id de Local Inválido!");
		}
		
		localRepository.deleteById(idlocal);
	}
	
}
