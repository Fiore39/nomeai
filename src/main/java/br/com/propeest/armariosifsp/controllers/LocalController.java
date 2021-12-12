package br.com.propeest.armariosifsp.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.propeest.armariosifsp.InputModels.LocalOutput;
import br.com.propeest.armariosifsp.service.ServiceLocal;

@RestController
@RequestMapping("/locais")
public class LocalController {

	private ServiceLocal serviceLocal;

	public LocalController(ServiceLocal serviceLocal) {
		super();
		this.serviceLocal = serviceLocal;
	}
	
	@GetMapping
	public List<LocalOutput> list(){
		return serviceLocal.listar();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public LocalOutput criar(@RequestBody LocalOutput localOutput) {
		return serviceLocal.adicionar(localOutput.getNome());
	}
	
	@PutMapping
	public LocalOutput update(@RequestBody LocalOutput localOutput){
		return serviceLocal.atualizar(localOutput);
	}
	
	@DeleteMapping("/{idlocal}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long idlocal) {
		serviceLocal.excluir(idlocal);
	}
	
}
