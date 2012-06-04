package br.com.novaroma.Negocio;

import br.com.Framework.generics.Negocio.EntidadeGenerics;

public class CartaoCredito extends EntidadeGenerics<CartaoCredito>{

	private int codigo;
	private int numCartao;
	private String bandeira;
	private String validade;
	private String codSeguranca;
	private int cliente_id;
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public int getNumCartao() {
		return numCartao;
	}
	public void setNumCartao(int numCartao) {
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
	public int getCliente_id() {
		return cliente_id;
	}
	public void setCliente_id(int cliente_id) {
		this.cliente_id = cliente_id;
	}
	
	@Override
	public boolean equals(Object obj){
		
		if (obj instanceof CartaoCredito){
			if (((CartaoCredito)obj).getNumCartao() == this.numCartao 
				&& ((CartaoCredito)obj).getCodSeguranca().equals(this.codSeguranca))
				return true;
			else
				return false;	
		}
		else
			return false;
	}
	@Override
	public int compareTo(CartaoCredito cartao) {
		
		if (cartao.getNumCartao() < this.numCartao)
			return -1;
		else if (cartao.getNumCartao() > this.numCartao)
			return 1;
		else
			return 0;
	}
	}