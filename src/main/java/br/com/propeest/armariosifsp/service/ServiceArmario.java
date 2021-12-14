package br.com.propeest.armariosifsp.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.propeest.armariosifsp.InputModels.ArmarioInput;
import br.com.propeest.armariosifsp.InputModels.ContratoInput;
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
	
	public Armario buscar(Long idarmario) {
		return armarioRepository.findById(idarmario)
				.orElseThrow(() -> new NegocioException("Armário não encontrado!"));
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
	public Contrato reservar(Long idarmario, ContratoInput contratoInput) {
		Armario armario = this.buscar(idarmario);
		armario.setStatus(StatusArmario.RESERVADO);
		armario = armarioRepository.save(armario);
		return serviceContrato.gerar(armario, contratoInput);
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
