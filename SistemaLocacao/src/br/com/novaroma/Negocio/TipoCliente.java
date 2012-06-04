package br.com.novaroma.Negocio;

public enum TipoCliente {

	NORMAL("NORMAL"), PREFERENCIAL("PREFERENCIAL");
	
	private String descricao;
	
	TipoCliente(String descricao){
		this.descricao = descricao;
	}
	
	public String getDescricao(){
		return descricao;
	}
}
