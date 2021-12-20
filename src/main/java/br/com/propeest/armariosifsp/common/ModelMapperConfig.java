package br.com.propeest.armariosifsp.common;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {
	
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
	/*
	 * Biblioteca ModelMapper
	 * Objetivo:
	 * Transformar um modelo de objeto para outro de uma forma simples e com pouco código
	 * 
	 * Precisa ser instanciado como um bean do Spring antes de ser instanciado em alguma classe, isso por ser uma 
	 * biblioteca independente
	 * */

}
