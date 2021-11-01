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
	
	public ArmarioController(ServiceArmario serviceArmario, ServiceBloco serviceBloco) {
		super();
		this.serviceArmario = serviceArmario;
		this.serviceBloco = serviceBloco;
	}

	@GetMapping
	public List<Armario> listar(@PathVariable Long idbloco){
		Bloco bloco = serviceBloco.buscar(idbloco);
		return bloco.getArmarios();
	}
	
	@PutMapping
	public List<Armario> alterar(@RequestBody List<Armario> armarios){
		return serviceArmario.atualizar(armarios);
	}
	
	@PutMapping("{idarmario}/aluguel")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public Contrato reservar(@PathVariable Long idarmario, @RequestBody Contrato contrato){
		return serviceArmario.reservar(idarmario, contrato);
	}
}
