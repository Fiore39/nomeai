package br.com.propeest.armariosifsp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.propeest.armariosifsp.InputModels.BlocoInput;
import br.com.propeest.armariosifsp.assembler.BlocoAssembler;
import br.com.propeest.armariosifsp.exceptions.NegocioException;
import br.com.propeest.armariosifsp.models.Armario;
import br.com.propeest.armariosifsp.models.Bloco;
import br.com.propeest.armariosifsp.repositories.BlocoRepository;

@Service
public class ServiceBloco {
	
	private BlocoRepository blocoRepository;
	private ServiceArmario serviceArmario;
	private BlocoAssembler blocoAssembler;
	
	public ServiceBloco(BlocoRepository blocoRepository, ServiceArmario serviceArmario, BlocoAssembler blocoAssembler) {
		super();
		this.blocoRepository = blocoRepository;
		this.serviceArmario = serviceArmario;
		this.blocoAssembler = blocoAssembler;
	}

	@Transactional
	public List<Armario> adicionar(BlocoInput blocoInput) {
		List<Armario> armarios = new ArrayList<Armario>();
		Bloco bloco = blocoAssembler.toEntity(blocoInput);
		bloco = blocoRepository.save(bloco);
		for (int i = 0; i < 16; i++) {
            armarios.add(serviceArmario.salvar(bloco, i + 1));
        }
		return armarios;
	}
	
	@Transactional
	public void excluir(Long idbloco) {
		blocoRepository.deleteById(idbloco);
	}
	
	public Bloco buscar(Long idbloco) {
		return blocoRepository.findById(idbloco)
				.orElseThrow(() -> new NegocioException("Bloco não encontrado!"));
	}

}
