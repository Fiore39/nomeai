package br.com.propeest.armariosifsp.service;

import java.time.OffsetDateTime;

import org.springframework.stereotype.Service;

import br.com.propeest.armariosifsp.InputModels.ContratoInput;
import br.com.propeest.armariosifsp.assembler.ContratoAssembler;
import br.com.propeest.armariosifsp.models.Armario;
import br.com.propeest.armariosifsp.models.Contrato;
import br.com.propeest.armariosifsp.repositories.ContratoRepository;

@Service
public class ServiceContrato {

	private ContratoRepository contratoRepository;
	private ContratoAssembler contratoAssembler;

	public ServiceContrato(ContratoRepository contratoRepository, ContratoAssembler contratoAssembler) {
		super();
		this.contratoRepository = contratoRepository;
		this.contratoAssembler = contratoAssembler;
	}
	
	public Contrato gerar(Armario armario, ContratoInput contratoInput) {
		Contrato contrato = contratoAssembler.toEntity(contratoInput);
		
		contrato.setArmario(armario);
		contrato.setDataAluguel(OffsetDateTime.now());
		contrato.setDataVencimento(OffsetDateTime.now().plusDays(3));
		return contratoRepository.save(contrato);
	}
	
	/*
	public void alugarArmario(Contrato contrato) {
        contratos.add(contrato);
    }

    public void encerrarContrato(Contrato contrato) {
        contratos.remove(contrato);
    }
	*/
	
}
