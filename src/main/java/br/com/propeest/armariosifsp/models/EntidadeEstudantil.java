package br.com.propeest.armariosifsp.models;

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
	
}
