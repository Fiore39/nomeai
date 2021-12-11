package br.com.propeest.armariosifsp.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import br.com.propeest.armariosifsp.InputModels.BlocoInput;
import br.com.propeest.armariosifsp.models.Bloco;
import br.com.propeest.armariosifsp.models.EntidadeEstudantil;

@Component
public class BlocoAssembler {

	private ModelMapper modelMapper;

	public BlocoAssembler(ModelMapper modelMapper) {
		super();
		this.modelMapper = modelMapper;
	}
	
	public Bloco toEntity(BlocoInput blocoInput) {
		return modelMapper.map(blocoInput, Bloco.class);
	}
	
	public Bloco toBloco(BlocoInput blocoInput) {
		Bloco bloco = new Bloco();
		bloco.setNome(blocoInput.getNome());
		bloco.setEntidadeEstudantil(EntidadeEstudantil.fromString(blocoInput.getEntidadeEstudantil()));
		
		return bloco;
	}
	
}
