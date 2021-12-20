package br.com.propeest.armariosifsp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.propeest.armariosifsp.InputModels.ArmarioInput;
import br.com.propeest.armariosifsp.assembler.ArmarioAssembler;
import br.com.propeest.armariosifsp.exceptions.NegocioException;
import br.com.propeest.armariosifsp.models.Armario;
import br.com.propeest.armariosifsp.models.Bloco;
import br.com.propeest.armariosifsp.models.StatusArmario;
import br.com.propeest.armariosifsp.repositories.ArmarioRepository;

@Service
public class ServiceArmario {

	private ArmarioRepository armarioRepository;
	private ArmarioAssembler armarioAssembler;
	
	public ServiceArmario(ArmarioRepository armarioRepository, ArmarioAssembler armarioAssembler) {
		super();
		this.armarioRepository = armarioRepository;
		this.armarioAssembler = armarioAssembler;
	}

	@Transactional
	public Armario salvar(Bloco bloco, int i) {
		Armario armario = new Armario(bloco);
		armario.setNome(bloco.getNome() + i);
		return armarioRepository.save(armario);
	}
	
	public Armario buscar(Long id, String nome) {
		Optional<Armario> armario = armarioRepository.findByIdAndNome(id, nome);
		
		if(armario.isEmpty()) {
			throw new NegocioException("Armário com id <" + id + "> e nome <" + nome + "> não encontrado!");
		}
		
		return armario.get();
	}
	
	public Armario buscarPorNome(String nome) {
		return armarioRepository.findByNome(nome)
				.orElseThrow(() -> new NegocioException("Armário não encontrado!"));
	}
	
	public List<Armario> getAllArmariosByBloco(Bloco bloco){
		return armarioRepository.findByBloco(bloco);
	}
	
	@Transactional
	public void atualizar(List<ArmarioInput> armarios){
		for(Armario armario: armarioAssembler.toCollectionEntity(armarios)) {
			Armario salvarArmario = this.buscarPorNome(armario.getNome());
			
			if((armario.getStatus().toString() != "") && (armario.getStatus() != null)) {
				if(!salvarArmario.getStatus().equals(armario.getStatus())) {
					salvarArmario.setStatus(armario.getStatus());
					armarioRepository.save(salvarArmario);
				}
			}
		}
	}
	
	@Transactional
	public Armario alugar(Long id, String nome) {
		Armario armario = this.buscar(id, nome);
		armario.setStatus(StatusArmario.ALUGADO);
		return armarioRepository.save(armario);
	}
	
	public Armario save(Armario armario) {
		return armarioRepository.save(armario);
	}

}
