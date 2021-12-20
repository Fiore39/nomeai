package br.com.propeest.armariosifsp.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import br.com.propeest.armariosifsp.InputModels.AluguelInput;
import br.com.propeest.armariosifsp.InputModels.ContratoOutput;
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
	
	public ContratoOutput toModel(Contrato contrato) {
		return modelMapper.map(contrato, ContratoOutput.class);
	}
	
	public List<ContratoOutput> toCollectionModel(List<Contrato> contratos){
		return contratos.stream()
				.map(this::toModel)
				.collect(Collectors.toList());
	}
}
