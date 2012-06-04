package br.com.novaroma.Negocio;

public enum StatusPagamento {
	PAGO("PAGO"), NAOPAGO("NAOPAGO");
	
	private String descricao;
		
	StatusPagamento(String desc){
		this.descricao = desc;
	}
	
	public String getDescricao(){
		return descricao;
	}
}
