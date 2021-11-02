package br.com.propeest.armariosifsp.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.propeest.armariosifsp.InputModels.BlocoInput;
import br.com.propeest.armariosifsp.models.Armario;
import br.com.propeest.armariosifsp.models.Bloco;
import br.com.propeest.armariosifsp.repositories.BlocoRepository;
import br.com.propeest.armariosifsp.service.ServiceBloco;

@RestController
@RequestMapping("/blocos")
public class BlocoController {
	
	private BlocoRepository blocoRepository;
	private ServiceBloco serviceBloco;
	
	public BlocoController(BlocoRepository blocoRepository, ServiceBloco serviceBloco) {
		super();
		this.blocoRepository = blocoRepository;
		this.serviceBloco = serviceBloco;
	}

	@GetMapping("/{entidadeEstudantil}")
	public List<Bloco> listar(@PathVariable String entidadeEstudantil){
		return blocoRepository.findByEntidadeEstudantil(entidadeEstudantil);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public List<Armario> criar(@Valid @RequestBody BlocoInput bloco){
		return serviceBloco.adicionar(bloco);
	}
	
	@DeleteMapping
	public ResponseEntity<Void> remover(@PathVariable Long idbloco){
		if(!blocoRepository.existsById(idbloco)) {
			return ResponseEntity.notFound().build();
		}
		blocoRepository.deleteById(idbloco);
		return ResponseEntity.noContent().build();
	}

}
