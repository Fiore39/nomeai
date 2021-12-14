package br.com.propeest.armariosifsp.service;

import java.time.OffsetDateTime;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.propeest.armariosifsp.InputModels.AluguelInput;
import br.com.propeest.armariosifsp.assembler.ContratoAssembler;
import br.com.propeest.armariosifsp.exceptions.NegocioException;
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
	
	public Contrato gerar(Armario armario, AluguelInput aluguelInput) {
		Contrato contrato = contratoAssembler.toEntity(aluguelInput);
		
		contrato.setArmario(armario);
		contrato.setDataAluguel(OffsetDateTime.now());
		contrato.setDataVencimento(OffsetDateTime.now().plusDays(3));
		contrato.setAtivo(true);
		return contratoRepository.save(contrato);
	}
	
	public void alugar(byte meses, Armario armario) {
		Optional<Contrato> optionalContrato = contratoRepository.findByArmario(armario);
		
		if (optionalContrato.isEmpty()) {
			throw new NegocioException("Não há contrato para armário com id <" + armario.getId() + "> e nome <" + armario.getNome() + ">");
		}
		
		Contrato contrato = optionalContrato.get();
		contrato.setDataAluguel(OffsetDateTime.now());
		contrato.setDataVencimento(OffsetDateTime.now().plusMonths(meses));
		contratoRepository.save(contrato);
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
