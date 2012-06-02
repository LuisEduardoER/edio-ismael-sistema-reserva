package br.com.novaroma.Negocio;

import br.com.Framework.generics.Negocio.EntidadeGenerics;

public class Grupo extends EntidadeGenerics<Grupo>{

	private String nome;
	private Double preco;

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
