package br.com.propeest.armariosifsp.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.propeest.armariosifsp.InputModels.AluguelInput;
import br.com.propeest.armariosifsp.InputModels.ArmarioInput;
import br.com.propeest.armariosifsp.InputModels.ArmarioOutput;
import br.com.propeest.armariosifsp.InputModels.ContratoOutput;
import br.com.propeest.armariosifsp.assembler.ArmarioAssembler;
import br.com.propeest.armariosifsp.models.Bloco;
import br.com.propeest.armariosifsp.service.ServiceArmario;
import br.com.propeest.armariosifsp.service.ServiceBloco;
import br.com.propeest.armariosifsp.service.ServiceContrato;

@RestController
@RequestMapping("/blocos/{entidadeEstudantil}/{nomeBloco}/armarios")
public class ArmarioController {

	private ServiceArmario serviceArmario;
	private ServiceBloco serviceBloco;
	private ServiceContrato serviceContrato;
	private ArmarioAssembler armarioAssembler;
	
	public ArmarioController(ServiceArmario serviceArmario, ServiceBloco serviceBloco, ServiceContrato serviceContrato, ArmarioAssembler armarioAssembler) {
		super();
		this.serviceArmario = serviceArmario;
		this.serviceBloco = serviceBloco;
		this.armarioAssembler = armarioAssembler;
		this.serviceContrato = serviceContrato;
	}

	@GetMapping
	public List<ArmarioOutput> listar(@PathVariable String entidadeEstudantil, @PathVariable String nomeBloco){
		Bloco bloco = serviceBloco.buscar(entidadeEstudantil, nomeBloco);
		
		return armarioAssembler.toCollectionModel(bloco.getArmarios());
	}
	
	@PutMapping
	public List<ArmarioOutput> alterar(@PathVariable String entidadeEstudantil, @PathVariable String nomeBloco, @RequestBody List<ArmarioInput> armarios){
		serviceBloco.checkEntidadeAndBloco(entidadeEstudantil, nomeBloco);
		serviceArmario.atualizar(armarios);
		return this.listar(entidadeEstudantil, nomeBloco);
	}
	
	@PutMapping("/aluguel")
	public ContratoOutput reservar(@PathVariable String entidadeEstudantil, @PathVariable String nomeBloco, @Valid @RequestBody AluguelInput aluguelInput){
		serviceBloco.checkEntidadeAndBloco(entidadeEstudantil, nomeBloco);
		return serviceContrato.reservar(aluguelInput);
	}
}
