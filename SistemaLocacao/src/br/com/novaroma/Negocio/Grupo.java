package br.com.novaroma.Negocio;

import br.com.Framework.generics.Negocio.EntidadeGenerics;

public class Grupo extends EntidadeGenerics<Grupo>{

	private int codigo;
	private String nome;
	private Double preco;
	private int carro_id;
	
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public int getCarro_id() {
		return carro_id;
	}

	public void setCarro_id(int carro_id) {
		this.carro_id = carro_id;
	}

	@Override
	public boolean equals(Object obj){
		
		if (obj instanceof Grupo){
			if (((Grupo)obj).getNome().equals(this.nome) && ((Grupo)obj).getPreco() == this.preco)
				return true;
			else
				return false;
		}
		else
			return false;
	}
	
	@Override
	public int compareTo(Grupo grupo) {
		
		if (grupo.getPreco() < this.preco)
			return -1;
		else if (grupo.getPreco() > this.preco)
			return 1;
		else
			return 0;
	}
}
