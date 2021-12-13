package br.com.propeest.armariosifsp.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import br.com.propeest.armariosifsp.InputModels.AluguelInput;
import br.com.propeest.armariosifsp.models.Contrato;

@Component
public class ContratoAssembler {

	private ModelMapper modelMapper;

	public ContratoAssembler(ModelMapper modelMapper) {
		super();
		this.modelMapper = modelMapper;
	}
	
	public Contrato toEntity(AluguelInput aluguelInput) {
		return modelMapper.map(aluguelInput, Contrato.class);
	}
}
