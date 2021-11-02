package br.com.propeest.armariosifsp.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.propeest.armariosifsp.InputModels.ArmarioOutput;
import br.com.propeest.armariosifsp.InputModels.ContratoInput;
import br.com.propeest.armariosifsp.assembler.ArmarioAssembler;
import br.com.propeest.armariosifsp.models.Armario;
import br.com.propeest.armariosifsp.models.Bloco;
import br.com.propeest.armariosifsp.models.Contrato;
import br.com.propeest.armariosifsp.service.ServiceArmario;
import br.com.propeest.armariosifsp.service.ServiceBloco;

@RestController
@RequestMapping("/blocos/{idbloco}/armarios")
public class ArmarioController {

	private ServiceArmario serviceArmario;
	private ServiceBloco serviceBloco;
	private ArmarioAssembler armarioAssembler;
	
	public ArmarioController(ServiceArmario serviceArmario, ServiceBloco serviceBloco, ArmarioAssembler armarioAssembler) {
		super();
		this.serviceArmario = serviceArmario;
		this.serviceBloco = serviceBloco;
		this.armarioAssembler = armarioAssembler;
	}

	@GetMapping
	public List<ArmarioOutput> listar(@PathVariable Long idbloco){
		Bloco bloco = serviceBloco.buscar(idbloco);
		
		return armarioAssembler.toCollectionModel(bloco.getArmarios());
	}
	
	@PutMapping
	public List<Armario> alterar(@RequestBody List<Armario> armarios){
		return serviceArmario.atualizar(armarios);
	}
	
	@PutMapping("/{idarmario}/aluguel")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public Contrato reservar(@PathVariable Long idarmario, @RequestBody ContratoInput contratoInput){
		return serviceArmario.reservar(idarmario, contratoInput);
	}
}
