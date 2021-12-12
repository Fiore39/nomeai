package br.com.propeest.armariosifsp.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import br.com.propeest.armariosifsp.InputModels.LocalOutput;
import br.com.propeest.armariosifsp.models.Local;

@Component
public class LocalAssembler {

	private ModelMapper modelMapper;

	public LocalAssembler(ModelMapper modelMapper) {
		super();
		this.modelMapper = modelMapper;
	}
	
	public LocalOutput toModel(Local local) {
		return modelMapper.map(local, LocalOutput.class);
	}
	
	public Local toEntity(LocalOutput localOutput) {
		return modelMapper.map(localOutput, Local.class);
	}
	
}
