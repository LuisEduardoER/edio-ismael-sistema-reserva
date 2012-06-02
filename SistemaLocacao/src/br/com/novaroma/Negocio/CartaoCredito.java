package br.com.novaroma.Negocio;

public class CartaoCredito {

	private String numCartao;
	private String bandeira;
	private String validade;
	private String codSeguranca;
	
	public String getNumCartao() {
		return numCartao;
	}
	public void setNumCartao(String numCartao) {
		this.numCartao = numCartao;
	}
	public String getBandeira() {
		return bandeira;
	}
	public void setBandeira(String bandeira) {
		this.bandeira = bandeira;
	}
	public String getValidade() {
		return validade;
	}
	public void setValidade(String validade) {
		this.validade = validade;
	}
	public String getCodSeguranca() {
		return codSeguranca;
	}
	public void setCodSeguranca(String codSeguranca) {
		this.codSeguranca = codSeguranca;
	}
	
	public boolean equals(Object obj){
		
		if (obj instanceof CartaoCredito){
			if (((CartaoCredito)obj).getNumCartao().equals(this.numCartao) 
				&& ((CartaoCredito)obj).getCodSeguranca().equals(this.codSeguranca))
				return true;
			else
				return false;	
		}
		else
			return false;
	}
}