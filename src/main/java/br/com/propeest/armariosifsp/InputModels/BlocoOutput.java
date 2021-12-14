package br.com.propeest.armariosifsp.InputModels;

public class BlocoOutput {
	
	private Long id;
	private String nome;
	private LocalOutput local;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public LocalOutput getLocal() {
		return local;
	}
	public void setLocal(LocalOutput local) {
		this.local = local;
	}

}
