package br.com.propeest.armariosifsp.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.propeest.armariosifsp.InputModels.ConfirmaPagamentoInput;
import br.com.propeest.armariosifsp.InputModels.ContratoOutput;
import br.com.propeest.armariosifsp.service.ServiceContrato;

@RestController
@RequestMapping
public class AluguelController {
	
	private ServiceContrato serviceContrato;

	public AluguelController(ServiceContrato serviceContrato) {
		super();
		this.serviceContrato = serviceContrato;
	}
	
	@GetMapping("/contratos/reservados/all")
	public List<ContratoOutput> listReservados(){
		return serviceContrato.listReservados();
	}
	
	@GetMapping("/contratos/reservados/{nome}")
	public List<ContratoOutput> listReservados(@PathVariable String nome){
		return serviceContrato.listReservados(nome);
	}
	
	@PutMapping("/confirmapagamento/{mesesAluguel}")
	public ContratoOutput confirmaPagamento(@PathVariable int mesesAluguel, @RequestBody @Valid ConfirmaPagamentoInput pagamentoInput) {
		return serviceContrato.alugar(mesesAluguel, pagamentoInput);
	}

}
