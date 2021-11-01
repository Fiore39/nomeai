package br.com.propeest.armariosifsp.service;

import java.time.OffsetDateTime;

import org.springframework.stereotype.Service;

import br.com.propeest.armariosifsp.models.Armario;
import br.com.propeest.armariosifsp.models.Contrato;
import br.com.propeest.armariosifsp.repositories.ContratoRepository;

@Service
public class ServiceContrato {

	private ContratoRepository contratoRepository;

	public ServiceContrato(ContratoRepository contratoRepository) {
		super();
		this.contratoRepository = contratoRepository;
	}
	
	public Contrato gerar(Armario armario, Contrato contrato) {
		contrato.setArmario(armario);
		contrato.setDataAluguel(OffsetDateTime.now());
		contrato.setDataVencimento(OffsetDateTime.now().plusDays(3));
		return contratoRepository.save(contrato);
	}
	
}
