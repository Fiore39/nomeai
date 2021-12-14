package br.com.propeest.armariosifsp.assembler;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import br.com.propeest.armariosifsp.InputModels.ArmarioInput;
import br.com.propeest.armariosifsp.InputModels.ArmarioOutput;
import br.com.propeest.armariosifsp.models.Armario;

@Component
public class ArmarioAssembler {

	private ModelMapper modelMapper;

	public ArmarioAssembler(ModelMapper modelMapper) {
		super();
		this.modelMapper = modelMapper;
	}
	
	public Armario toEntity(ArmarioInput armario) {
		return modelMapper.map(armario, Armario.class);
	}
	
	public List<Armario> toCollectionEntity(List<ArmarioInput> armarios){
		return armarios.stream()
			.map(this::toEntity)
			.collect(Collectors.toList());
	}
	
	public ArmarioOutput toModel(Armario armario) {
		return modelMapper.map(armario, ArmarioOutput.class);
	}
	
	public List<ArmarioOutput> toCollectionModel(List<Armario> armarios){
		List<ArmarioOutput> armariosOutput = armarios.stream()
												.map(this::toModel)
												.collect(Collectors.toList());
		Collections.sort(armariosOutput);
		return armariosOutput;
	}
	
}
