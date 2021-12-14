package br.com.propeest.armariosifsp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.propeest.armariosifsp.InputModels.AluguelInput;
import br.com.propeest.armariosifsp.InputModels.ArmarioInput;
import br.com.propeest.armariosifsp.InputModels.ArmarioNomeInput;
import br.com.propeest.armariosifsp.assembler.ArmarioAssembler;
import br.com.propeest.armariosifsp.exceptions.NegocioException;
import br.com.propeest.armariosifsp.models.Armario;
import br.com.propeest.armariosifsp.models.Bloco;
import br.com.propeest.armariosifsp.models.Contrato;
import br.com.propeest.armariosifsp.models.StatusArmario;
import br.com.propeest.armariosifsp.repositories.ArmarioRepository;

@Service
public class ServiceArmario {

	private ArmarioRepository armarioRepository;
	private ServiceContrato serviceContrato;
	private ArmarioAssembler armarioAssembler;
	
	public ServiceArmario(ArmarioRepository armarioRepository, ServiceContrato serviceContrato, ArmarioAssembler armarioAssembler) {
		super();
		this.armarioRepository = armarioRepository;
		this.serviceContrato = serviceContrato;
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
	public Contrato reservar(AluguelInput aluguelInput) {
		Armario armario = this.buscar(aluguelInput.getArmario().getId(), aluguelInput.getArmario().getNome());
		armario.setStatus(StatusArmario.RESERVADO);
		armario = armarioRepository.save(armario);
		return serviceContrato.gerar(armario, aluguelInput);
	}
	
	@Transactional
	public void alugar(byte meses, ArmarioNomeInput armarioInput) {
		
		if (meses > 12) {
			throw new NegocioException("Período de Aluguel maior que 12 meses");
		}
		
		Armario armario = this.buscar(armarioInput.getId(), armarioInput.getNome());
		armario.setStatus(StatusArmario.ALUGADO);
		armario = armarioRepository.save(armario);
		/*return*/ serviceContrato.alugar(meses, armario);
	}
	/*
    public void alugar(Contrato contrato) {
        this.contrato = contrato;
        this.status = StatusArmario.ALUGADO;
    }

    public void liberar() {
        if (this.status.equals(StatusArmario.ALUGADO) || this.status.equals(StatusArmario.RESERVADO)) {
            this.contrato = null;
        }
        this.status = StatusArmario.LIVRE;
    }*/
}
