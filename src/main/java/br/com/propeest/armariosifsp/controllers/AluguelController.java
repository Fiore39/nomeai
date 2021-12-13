package br.com.propeest.armariosifsp.controllers;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.propeest.armariosifsp.InputModels.ArmarioNomeInput;
import br.com.propeest.armariosifsp.service.ServiceArmario;

@RestController
@RequestMapping("/confirmapagamento/{mesesAluguel}")
public class AluguelController {
	
	private ServiceArmario serviceArmario;

	public AluguelController(ServiceArmario serviceArmario) {
		super();
		this.serviceArmario = serviceArmario;
	}
	
	@PutMapping
	public void confirmaPagamento(@PathVariable byte meses, @RequestBody @Valid ArmarioNomeInput armario) {
		serviceArmario.alugar(meses, armario);
	}

}
