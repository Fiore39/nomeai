package br.com.propeest.armariosifsp.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import br.com.propeest.armariosifsp.InputModels.BlocoInput;
import br.com.propeest.armariosifsp.models.Bloco;

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
	
}
