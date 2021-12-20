package br.com.propeest.armariosifsp.service;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.propeest.armariosifsp.InputModels.AluguelInput;
import br.com.propeest.armariosifsp.InputModels.ConfirmaPagamentoInput;
import br.com.propeest.armariosifsp.InputModels.ContratoOutput;
import br.com.propeest.armariosifsp.assembler.ContratoAssembler;
import br.com.propeest.armariosifsp.exceptions.NegocioException;
import br.com.propeest.armariosifsp.models.Aluno;
import br.com.propeest.armariosifsp.models.Armario;
import br.com.propeest.armariosifsp.models.Contrato;
import br.com.propeest.armariosifsp.models.StatusArmario;
import br.com.propeest.armariosifsp.repositories.ContratoRepository;

@Service
public class ServiceContrato {

	private ContratoRepository contratoRepository;
	private ContratoAssembler contratoAssembler;
	private ServiceArmario serviceArmario;
	private ServiceAluno serviceAluno;

	public ServiceContrato(ContratoRepository contratoRepository, ContratoAssembler contratoAssembler, ServiceArmario serviceArmario, ServiceAluno serviceAluno) {
		super();
		this.contratoRepository = contratoRepository;
		this.contratoAssembler = contratoAssembler;
		this.serviceArmario = serviceArmario;
		this.serviceAluno = serviceAluno;
	}
	
	public ContratoOutput reservar(AluguelInput aluguelInput) {
		Armario armario = serviceArmario.buscar(aluguelInput.getArmario().getId(), aluguelInput.getArmario().getNome());
		Aluno aluno = serviceAluno.buscarEmail(aluguelInput.getAluno().getEmail());
		
		if (armario.getStatus() != StatusArmario.LIVRE) {
			throw new NegocioException("Armário não está Livre!");
		}
		
		armario.setStatus(StatusArmario.RESERVADO);
		Armario armarioSalvo = serviceArmario.save(armario);
		
		Contrato contrato = contratoAssembler.toEntity(aluguelInput);
		contrato.setArmario(armarioSalvo);
		contrato.setDataAluguel(OffsetDateTime.now());
		contrato.setDataVencimento(OffsetDateTime.now().plusDays(3));
		contrato.setAtivo(false);
		contrato.setAluno(aluno);
		
		return contratoAssembler.toModel(contratoRepository.save(contrato));
	}
	
	public ContratoOutput alugar(int meses, ConfirmaPagamentoInput pagamentoInput) {
		
		if (meses > 12) {
			throw new NegocioException("Período de Aluguel maior que 12 meses");
		}
		
		Optional<Contrato> optionalContrato = contratoRepository.findById(pagamentoInput.getId());
		
		if (optionalContrato.isEmpty()) {
			throw new NegocioException("Não há nenhum contrato com as informações dadas!");
		}
		
		Aluno admin = serviceAluno.buscarEmail(pagamentoInput.getAdmin().getEmail());
		
		Contrato contrato = optionalContrato.get();
		
		if (contrato.getArmario().getStatus() != StatusArmario.RESERVADO) {
			throw new NegocioException("Não foi possível alugar pois o armário não está reservado");
		}
		if (contrato.getAdmin() != null) {
			throw new NegocioException("O contrato já foi ativado e o pagamento efetivado!");
		}
		
		contrato.setDataAluguel(OffsetDateTime.now());
		contrato.setDataVencimento(OffsetDateTime.now().plusMonths(meses));
		contrato.setAtivo(true);
		contrato.setAdmin(admin);
		
		serviceArmario.alugar(contrato.getArmario().getId(), contrato.getArmario().getNome());
		
		return contratoAssembler.toModel(contratoRepository.save(contrato));
	}
	
	public List<ContratoOutput> listReservados(){
		List<Contrato> contratos = contratoRepository.findByStatusArmario(StatusArmario.RESERVADO);
		
		return contratoAssembler.toCollectionModel(contratos);
	}
	
	public List<ContratoOutput> listReservados(String nome){
		List<Contrato> contratos = contratoRepository.findByStatusArmarioAndNome(StatusArmario.RESERVADO, nome);
		
		return contratoAssembler.toCollectionModel(contratos);
	}
	
}
