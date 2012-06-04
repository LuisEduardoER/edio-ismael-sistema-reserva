package br.com.novaroma.Negocio;

public enum TipoSituacao {

	DISPONIVEL("DISPONIVEL"), EMPRESTADO("EMPRESTADO");
	
	private String descricao;
	
	TipoSituacao (String descricao){
		this.descricao = descricao;
	}
	
	public String getDescricao(){
		return descricao;
	}
}
