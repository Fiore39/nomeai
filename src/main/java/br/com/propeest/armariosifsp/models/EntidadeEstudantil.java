package br.com.propeest.armariosifsp.models;

import br.com.propeest.armariosifsp.exceptions.NegocioException;

public enum EntidadeEstudantil {
	
	GREMIO_ESTUDANTIL("Grêmio Estudantil"), DIRETORIO_ACADEMICO("Diretório Acadêmico");
	
	private final String valor;
	
	EntidadeEstudantil(String valor){
		this.valor = valor;
	}

	public String getValor() {
		return valor;
	}
	
	public String toString(){
        return valor;
	}
	
	public static EntidadeEstudantil fromString(String nomeEntidadeEstudantil) {
        for (EntidadeEstudantil entidadeEstudantil : EntidadeEstudantil.values()) {
            if (entidadeEstudantil.valor.equalsIgnoreCase(nomeEntidadeEstudantil)) {
                return entidadeEstudantil;
            }
        }
        throw new NegocioException("Entidade Estudantil inválida!");
    }
	
}
