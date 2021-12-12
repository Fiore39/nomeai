package br.com.propeest.armariosifsp.models;

import br.com.propeest.armariosifsp.exceptions.NegocioException;

public enum EntidadeEstudantil {
	
	GREMIO("Grêmio Estudantil"), DA("Diretório Acadêmico");
	
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
        	//Possiveis substituições comentadas abaixo
            if (entidadeEstudantil.name().equalsIgnoreCase(nomeEntidadeEstudantil.toUpperCase())) {
                return entidadeEstudantil;
            }
        }
        throw new NegocioException("Entidade Estudantil inválida!");
    }
	
}
/*
if (entidadeEstudantil.valor.equalsIgnoreCase(nomeEntidadeEstudantil)) {
    return entidadeEstudantil;
}
if (EntidadeEstudantil.valueOf(blocoInput.getEntidadeEstudantil().toUpperCase()) == EntidadeEstudantil.DA) {
	bloco.setEntidadeEstudantil(EntidadeEstudantil.DA);
} else
if (EntidadeEstudantil.valueOf(blocoInput.getEntidadeEstudantil().toUpperCase()) == EntidadeEstudantil.GREMIO) {
	bloco.setEntidadeEstudantil(EntidadeEstudantil.GREMIO);
}*/