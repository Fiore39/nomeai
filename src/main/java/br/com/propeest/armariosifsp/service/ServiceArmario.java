package br.com.propeest.armariosifsp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	
	public ServiceArmario(ArmarioRepository armarioRepository, ServiceContrato serviceContrato) {
		super();
		this.armarioRepository = armarioRepository;
		this.serviceContrato = serviceContrato;
	}

	@Transactional
	public Armario salvar(Bloco bloco) {
		Armario armario = new Armario(bloco);
		return armarioRepository.save(armario);
	}
	
	public Armario buscar(Long idarmario) {
		return armarioRepository.findById(idarmario)
				.orElseThrow(() -> new NegocioException("Armário não encontrado!"));
	}
	
	@Transactional
	public List<Armario> atualizar(List<Armario> armarios){
		List<Armario> armariosAtualizados = new ArrayList<>();
		for(Armario armario: armarios) {
			Armario salvarArmario = this.buscar(armario.getId());
			if((armario.getStatus().toString() != "") && (armario.getStatus() != null)) {
				salvarArmario.setStatus(armario.getStatus());
			}
			if((armario.getNome() != "") && (armario.getNome() != null)) {
				salvarArmario.setNome(armario.getNome());
			}
			armariosAtualizados.add(armarioRepository.save(salvarArmario));
		}
		return armariosAtualizados;
	}
	
	@Transactional
	public Contrato reservar(Long idarmario, Contrato contrato) {
		Armario armario = this.buscar(idarmario);
		armario.setStatus(StatusArmario.RESERVADO);
		armario = armarioRepository.save(armario);
		return serviceContrato.gerar(armario, contrato);
	}
}
